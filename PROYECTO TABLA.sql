USE TEST;
DROP TABLE IF EXISTS tags_product;
DROP TABLE IF EXISTS tags;
DROP TABLE IF EXISTS Product;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS audi_log;
DROP TABLE IF EXISTS user_;

CREATE TABLE IF NOT EXISTS user_ (
id_User INT PRIMARY KEY AUTO_INCREMENT,
Username VARCHAR(255),
Password_user VARCHAR(255),
Role_ VARCHAR(255),
Last_connection TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS Audi_Log (
id_audilog INT PRIMARY KEY AUTO_INCREMENT,
AudiLog_Author VARCHAR(255),
AudiLog_Action VARCHAR(255),
AudiLog_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
User_id INT,
FOREIGN KEY (User_id)
REFERENCES User_(id_User)
);

CREATE TABLE IF NOT EXISTS category (
id_category INT PRIMARY KEY AUTO_INCREMENT,
name_category VARCHAR(255)
);



CREATE TABLE IF NOT EXISTS product (
id_product INT PRIMARY KEY AUTO_INCREMENT,
description_ VARCHAR(255),
location VARCHAR(255),
date_product DATE,
FOREIGN KEY (id_product)
REFERENCES category(id_category)
);

CREATE TABLE IF NOT EXISTS tags (
id_tags INT PRIMARY KEY AUTO_INCREMENT,
name_tags VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS tags_product (
id INT PRIMARY KEY AUTO_INCREMENT,
tags_id INT,
product_id INT,
FOREIGN KEY (tags_id)
REFERENCES tags(id_tags)
	ON DELETE CASCADE
	ON UPDATE CASCADE,
FOREIGN KEY (product_id)
REFERENCES product(id_product)
	ON DELETE CASCADE
	ON UPDATE CASCADE
);

INSERT user_(Username, Password_user, Role_, Last_connection ) 

	VALUES 
		('Pedrito_102','Yatusabe202', 'ADMIN', DEFAULT),
		('Sandra','Me organizo', 'USER', DEFAULT);

INSERT Audi_Log(AudiLog_Author, AudiLog_Action, AudiLog_date, user_id ) 

	VALUES 
		('Pedro','CREATE - Category:Shoes', DEFAULT, '1'),
		('Sandra','UPDATE - Category:Pants', DEFAULT, '2');

INSERT category( name_category) 

	VALUES 
		('SHOES'),
		('PANTS');



INSERT product(description_ , location, date_product) 

	VALUES 
		('Lorem ipsum dolor sit amet, consectetur adipiscing elit. 		Sed do eiusmod tempor incididunt ut labore et dolore 			magna aliqua.','Estados unidos', curdate()),
		('Lorem ipsum dolor sit amet, consectetur adipiscing elit. 		Sed do eiusmod tempor incididunt ut labore et dolore 			magna aliqua.','España', curdate());
		

INSERT tags (name_tags) 

	VALUES 
		('Sport'),
		('JEANS');

INSERT tags_product (tags_id,product_id) 

	VALUES 
		(1,1),
		(2,2);

SELECT * FROM User_;
SELECT * FROM Audi_Log;
SELECT * FROM category;
SELECT * FROM product;
SELECT * FROM tags;
SELECT * FROM tags_product;





