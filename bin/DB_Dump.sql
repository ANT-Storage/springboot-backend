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
    name VARCHAR(255),
    description VARCHAR(255),
    location VARCHAR(255),
    date DATE,
    category_id INT,
    FOREIGN KEY (category_id) REFERENCES category(id)
);

CREATE TABLE IF NOT EXISTS tags (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS tags_product (
    id INT PRIMARY KEY AUTO_INCREMENT,
    tags_id INT,
    product_id INT,
    FOREIGN KEY (tags_id) REFERENCES tags(id) ON DELETE CASCADE ON UPDATE CASCADE,
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
    ('PANTS');

INSERT INTO product (name, description, location, date, category_id)
VALUES
    ('Product 1', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 'Estados unidos', CURDATE(), 1),
    ('Product 2', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 'España', CURDATE(), 2);

INSERT INTO tags (name)
VALUES
    ('Sport'),
    ('JEANS');

INSERT INTO tags_product (tags_id, product_id)
VALUES
    (1, 1),
    (2, 2);

SELECT * FROM user;
SELECT * FROM audi_log;
SELECT * FROM category;
SELECT * FROM product;
SELECT * FROM tags;
SELECT * FROM tags_product;
