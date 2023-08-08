package med.voll.api.infra.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/*
 * Nesta classe iremos concentrar as configurações do Spring Security
 * 1- Adicionar @Configuration e @EnableWebSecurity
 */

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {
    
    /* Configuração do processo de autenticação
     * Não é mais Stateful e sim Stateless
     * 
     * 1- SecutiryFilterChain é o objeto do Spring que faz esse processo de autenticação
     * 
     * 2- HttpSecurity vai ser dado pelo proprio Spring
     *      - Então, utilizamos seus metodos
     * 
     * 3- Precisamos realizar 3 coisas com o objeto HttpSecurity (as 3 linhas)
     *      1. Desabilitar a proteção csrf, pois o proprio TOKEN que vamos usar ja faz isso
     *      2. Definir que estaremos utilizando uma autenticação Stateless
     *      3. E buildar, retornando assim o SecurityFilterChain
     * 
     * 4- @Bean faz com que o metodo devolva um objeto para o Spring, necessario aqui
     * 
     * Essa configuração, faz com que o Spring Security deixa de ser Stateful, e não nos trave mais
     * nos endpoints da API
     */ 
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http.csrf().disable()
               .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
               .and().build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception{
        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
