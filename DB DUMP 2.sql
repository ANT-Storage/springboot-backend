USE TEST;

DROP TABLE IF EXISTS tags_product;
DROP TABLE IF EXISTS tag;
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
    name VARCHAR(255),
    description VARCHAR(255),
    location VARCHAR(255),
    date DATE,
    category_id INT,
    url_img VARCHAR(255),
    FOREIGN KEY (category_id) REFERENCES category(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS tag (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS tags_product (
    id INT PRIMARY KEY AUTO_INCREMENT,
    tags_id INT,
    product_id INT,
    FOREIGN KEY (tags_id) REFERENCES tag(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (product_id) REFERENCES product(id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO user (username, password, role, last_connection)
VALUES
    ('admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 'ADMIN', CURRENT_TIMESTAMP),
    ('user_1', '79b0aa0042b3c05617c378046a6553ec2cd81e9995959a6012f9b497a18ec82b', 'USER', CURRENT_TIMESTAMP);

INSERT INTO audi_log (author, action, date)
VALUES
    ('admin', 'CREATE - Category:Shoes', CURRENT_TIMESTAMP),
    ('admin', 'UPDATE - Category:Pants', CURRENT_TIMESTAMP);

INSERT INTO category (name)
VALUES
    ('SHOES'),
    ('PANTS'),
    ('SWEATSHIRTS'),
    ('SOCKS'),
    ('JACKET');

INSERT INTO product (name, description, location, date, category_id)
VALUES
    ('Product 1', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 'USA', CURDATE(), 1),
    ('Product 2', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 'Spain', CURDATE(), 2),
	('Product 3', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 'Canada', CURDATE(), 3),
	('Product 4', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 'China', CURDATE(), 4),
	('Product 5', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 'USA', CURDATE(), 5);
INSERT INTO tag (name)
VALUES
	('RED'),
    ('BLUE'),
    ('GREEN'),
    ('BLACK'),
    ('WHITE'),
	('YELLOW'),
    ('PURPLE'),
    ('PINK'),
    ('ORANGE'),
    ('GRAY'),
	('SPORT'),
    ('JEANS'),
    ('CASUAL'),
    ('FORMAL'),
    ('SUMMER'),
    ('WINTER'),
    ('ATHLEISURE'),
    ('VINTAGE'),
    ('xs'),
    ('s'),
    ('M'),
    ('L'),
	('XL'),
    ('XXL'),
	('XXXL'),
	(33),
	(34),
    (35),
	(36),
	(37),
	(38),
    (39),
	(40),     
    (41),
	(42),
    (43),
	(44),
	(45),
	(46),
    ('33-35'),
    ('36-38'),
    ('39-42'),
    ('43-46');
    
INSERT INTO tags_product (tags_id, product_id)
VALUES
    (4, 1),
    (11, 1),
    (36, 1),
    (5, 2),
    (12, 2),
    (21, 2),
	(32, 2),
    (1, 3),
    (17, 3),
    (22, 3),
    (5, 4),
    (15, 4),
    (41, 4),
	(2, 5),
    (14, 5),
    (24, 5);
    
SELECT * FROM user;
SELECT * FROM audi_log;
SELECT * FROM category;
SELECT * FROM product;
SELECT * FROM tag;
SELECT * FROM tags_product;