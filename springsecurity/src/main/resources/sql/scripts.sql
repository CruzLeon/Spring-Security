drop database springsecuritydatabase;
create database springsecuritydatabase;

use springsecuritydatabase;

CREATE TABLE customer(
    id INT NOT NULL AUTO_INCREMENT,
    email VARCHAR(50) NOT NULL,
    usern VARCHAR(50) NOT NULL,
    pass VARCHAR(50) NOT NULL,
    role VARCHAR(50) NOT NULL,
    primary key(id)
);

INSERT INTO customer VALUES(null, 'user1@user1.com', 'user1', 'user1', 'write');
