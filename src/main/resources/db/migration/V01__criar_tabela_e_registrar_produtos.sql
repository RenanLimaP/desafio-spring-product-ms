CREATE TABLE produto (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	description VARCHAR(30),
	price DECIMAL(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO produto (name, description, price) values ('Televisão', 'Smart TV 50 polegadas', 2000);
INSERT INTO produto (name, description, price) values ('SmartPhone', 'Samsung', 1000);
