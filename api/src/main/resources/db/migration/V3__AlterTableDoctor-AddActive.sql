alter table tb_doctor add active tinyint;
update tb_doctor set active = 1;
