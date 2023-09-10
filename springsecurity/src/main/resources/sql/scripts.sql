drop database springsecuritydatabase;
create database springsecuritydatabase;

use springsecuritydatabase;

CREATE TABLE users(
    id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    enabled INT NOT NULL,
    primary key(id)
);

CREATE TABLE authorities(
    id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    PRIMARY KEY(id)
);

INSERT INTO users VALUES(NULL, 'user1', 'user1', '1');
INSERT INTO authorities VALUES (NULL, 'user1', 'write');