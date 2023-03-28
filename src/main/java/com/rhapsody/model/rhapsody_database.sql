DROP DATABASE IF EXISTS rhapsody_database;
CREATE DATABASE rhapsody_database; 
USE rhapsody_database;

DROP TABLE IF EXISTS EVENTS;
CREATE TABLE EVENTS (
	id			VARCHAR(100) UNIQUE,
    title		VARCHAR(50),
    content		VARCHAR(1000),
    PRIMARY KEY (id)
);