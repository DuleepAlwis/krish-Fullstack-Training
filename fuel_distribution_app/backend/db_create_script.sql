CREATE DATABASE if NOT exists fuel_distribution_db;
USE fuel_distribution_db;

CREATE TABLE if NOT EXISTS order_tb(

id BIGINT PRIMARY KEY AUTO_INCREMENT,
gas_station_name VARCHAR(255),
gas_station_id VARCHAR(255),
TYPE_of_fuel VARCHAR(255),
amount_needed VARCHAR(255),
city VARCHAR(255),
district VARCHAR(255),
address VARCHAR(255),
status INT 
);

CREATE TABLE if NOT EXISTS fuel_props(

id BIGINT PRIMARY KEY AUTO_INCREMENT,
NAME VARCHAR(255),
stock_amount VARCHAR(255)
);
CREATE TABLE If NOT EXISTS app_props(

id BIGINT PRIMARY KEY AUTO_INCREMENT,
property VARCHAR(255),
VALUE VARCHAR(255)
);

#DROP DATABASE fuel_distribution_db

INSERT INTO fuel_props VALUES(1,"Reserved_Stock",100000);
INSERT INTO fuel_props VALUES(2,"Available_Stock",100000);
SELECT * FROM fuel_props;
SELECT * FROM order_tb;