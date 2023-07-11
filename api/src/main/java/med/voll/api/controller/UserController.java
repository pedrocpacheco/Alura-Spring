package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.domain.user.UserAuthenticationDTO;

@RestController
@RequestMapping("/login")
public class UserController {
    
    /*
     * Chamado para utilizar o UserSerice, não utilizamos ele direto (o service)
     */
    @Autowired
    private AuthenticationManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity executeLogin(@RequestBody @Valid UserAuthenticationDTO data){
        var token = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var authentication = manager.authenticate(token);

        return ResponseEntity.ok().build();
    }

}
