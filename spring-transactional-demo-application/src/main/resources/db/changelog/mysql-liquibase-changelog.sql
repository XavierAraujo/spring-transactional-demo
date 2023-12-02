--liquibase formatted sql

--changeset spring-transactional-demo:1

CREATE TABLE IF NOT EXISTS account (
    account_id VARCHAR(64) PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS account_visited_city (
    id INT AUTO_INCREMENT PRIMARY KEY,
    account_id VARCHAR(64),
    city_name VARCHAR(64)
);
