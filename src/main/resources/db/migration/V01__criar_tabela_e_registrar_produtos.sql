CREATE TABLE produto (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	description VARCHAR(30),
	price DECIMAL(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO produto (name, description, price) values ('Televisão', 'Smart TV 50 polegadas', 3000.00);
INSERT INTO produto (name, description, price) values ('Smartphone', 'Samsung', 1000.00	);
INSERT INTO produto (name, description, price) values ('Geladeira', '1 Porta degelo seco', 2499.99);
INSERT INTO produto (name, description, price) values ('Máquina de Lavar', 'Bratempo 12Kg', 3000.00);
INSERT INTO produto (name, description, price) values ('Computador', 'PC Gamer', 5000.00);
