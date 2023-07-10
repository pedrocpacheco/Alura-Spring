create table tb_doctor(

    id bigint not null auto_increment,
    nm_doctor varchar(100) not null,
    em_doctor varchar(100) not null unique,
    crm_doctor varchar(6) not null unique,
    spe_doctor varchar(100) not null,
    street_doctor varchar(100) not null,
    neigh_doctor varchar(100) not null,
    cep_doctor varchar(9) not null,
    comp_doctor varchar(100),
    num_doctor varchar(20),
    uf_doctor char(2) not null,
    city_doctor varchar(100) not null,

    primary key(id)

);