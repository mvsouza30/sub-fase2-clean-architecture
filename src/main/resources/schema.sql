CREATE TABLE IF NOT EXISTS `cars` (
  id bigint AUTO_INCREMENT primary key,
  marca varchar(25) not null,
  modelo varchar(25) not null,
  cor varchar(10) not null,
  ano int not null,
  preco double not null
);