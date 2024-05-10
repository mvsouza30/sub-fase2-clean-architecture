CREATE TABLE IF NOT EXISTS `cars` (
  id bigint AUTO_INCREMENT primary key,
  marca varchar(25) not null,
  modelo varchar(25) not null,
  cor varchar(10) not null,
  ano int not null,
  preco double not null,
  descricao varchar(255) not null
);

CREATE TABLE IF NOT EXISTS `carsales` (
  id bigint AUTO_INCREMENT primary key,
  cpf varchar(15) not null,
  car_id int not null,
  sale_date varchar(10) not null,
  payment_method varchar(15) not null,
  entry double not null,
  remaining_amount double not null,
  number_of_installments int not null
);