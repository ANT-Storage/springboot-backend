USE TEST;
DROP TABLE IF EXISTS tags_product;
DROP TABLE IF EXISTS tags;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS audi_log;
DROP TABLE IF EXISTS user;

CREATE TABLE IF NOT EXISTS user (
id INT PRIMARY KEY AUTO_INCREMENT,
username VARCHAR(255),
password VARCHAR(255),
role VARCHAR(255),
last_connection TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS audi_log (
id INT PRIMARY KEY AUTO_INCREMENT,
author VARCHAR(255),
action VARCHAR(255),
date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS category (
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(255)
);



CREATE TABLE IF NOT EXISTS product (
id INT PRIMARY KEY AUTO_INCREMENT,
description VARCHAR(255),
location VARCHAR(255),
date DATE,
category_id INT,
FOREIGN KEY (id)
REFERENCES category(id)
);

CREATE TABLE IF NOT EXISTS tags (
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS tags_product (
id INT PRIMARY KEY AUTO_INCREMENT,
tags_id INT,
product_id INT,
FOREIGN KEY (tags_id)
REFERENCES tags(id)
	ON DELETE CASCADE
	ON UPDATE CASCADE,
FOREIGN KEY (product_id)
REFERENCES product(id)
	ON DELETE CASCADE
	ON UPDATE CASCADE
);

INSERT user (username, password, role, last_connection )

	VALUES
		('Pedrito_102','Yatusabe202', 'ADMIN', DEFAULT),
		('Sandra','Me organizo', 'USER', DEFAULT);

INSERT audi_Log(author, action, date )

	VALUES
		('Pedro','CREATE - Category:Shoes', DEFAULT),
		('Sandra','UPDATE - Category:Pants', DEFAULT);

INSERT category(name)

	VALUES
		('SHOES'),
		('PANTS');



INSERT product(description , location, date , category_id)

	VALUES
		('Lorem ipsum dolor sit amet, consectetur adipiscing elit. 		Sed do eiusmod tempor incididunt ut labore et dolore 			magna aliqua.','Estados unidos', curdate(),'1'),
		('Lorem ipsum dolor sit amet, consectetur adipiscing elit. 		Sed do eiusmod tempor incididunt ut labore et dolore 			magna aliqua.','España', curdate(),'2');


INSERT tags (name)

	VALUES
		('Sport'),
		('JEANS');

INSERT tags_product (tags_id,product_id)

	VALUES
		(1,1),
		(2,2);

SELECT * FROM user;
SELECT * FROM audi_Log;
SELECT * FROM category;
SELECT * FROM product;
SELECT * FROM tags;
SELECT * FROM tags_product;

