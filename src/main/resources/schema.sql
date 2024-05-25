CREATE TABLE IF NOT EXISTS `cars` (
  id bigint AUTO_INCREMENT primary key,
  marca varchar(25) not null,
  modelo varchar(25) not null,
  cor varchar(10) not null,
  ano int not null,
  preco double not null,
  descricao varchar(255) not null
);

CREATE TABLE IF NOT EXISTS `pre_sales` (
  id bigint AUTO_INCREMENT primary key,
  cpf varchar(15) not null,
  data varchar(15) not null,
  marca varchar(25) not null,
  modelo varchar(25) not null,
  cor varchar(10) not null,
  ano int not null,
  preco double not null,
  descricao varchar(255) not null,
  cod_vendas varchar(25) not null,
  status varchar(15) not null
);

CREATE TABLE IF NOT EXISTS `sold_cars` (
  id bigint AUTO_INCREMENT primary key,
  cpf varchar(15) not null,
  data varchar(15) not null,
  marca varchar(25) not null,
  modelo varchar(25) not null,
  cor varchar(10) not null,
  ano int not null,
  preco double not null,
  descricao varchar(255) not null,
  cod_vendas varchar(25) not null,
  status varchar(15) not null
);