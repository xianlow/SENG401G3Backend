DROP DATABASE IF EXISTS rhapsody_database;
CREATE DATABASE rhapsody_database; 
USE rhapsody_database;

DROP TABLE IF EXISTS EVENTS;
CREATE TABLE EVENTS (
	eventId			VARCHAR(254) UNIQUE,
    timestamp		DATE,
    aggregateId		TEXT,
    PRIMARY KEY (eventId)
);