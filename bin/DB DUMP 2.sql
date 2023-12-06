USE TEST;

DROP TABLE IF EXISTS tags_product;
DROP TABLE IF EXISTS tag;
DROP TABLE IF EXISTS product_image;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS category_image;
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

CREATE TABLE IF NOT EXISTS images (
     id INT PRIMARY KEY AUTO_INCREMENT,
     name VARCHAR(255),
     storage_url VARCHAR(255),
     public_url VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS category (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    image_id INTEGER,
    FOREIGN KEY (image_id) REFERENCES images(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS product (
    id INT PRIMARY KEY AUTO_INCREMENT,
    barcode VARCHAR(255),
    name VARCHAR(255),
    description TEXT,
    location VARCHAR(255),
    date VARCHAR(10),
    category_id INT,
    image_id INTEGER,
    FOREIGN KEY (category_id) REFERENCES category(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (image_id) REFERENCES images(id) ON DELETE CASCADE ON UPDATE CASCADE
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
    ('admin', 'admin_password', 'ADMIN', CURRENT_TIMESTAMP),
    ('user_1', 'user_password', 'USER', CURRENT_TIMESTAMP);

SELECT * FROM user;
SELECT * FROM audi_log;
SELECT * FROM category;
SELECT * FROM product;
SELECT * FROM tag;
SELECT * FROM tags_product;
SELECT * FROM category_image;
SELECT * FROM product_image;