DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  dt_received date DEFAULT NULL,
  nationality VARCHAR(250) DEFAULT NULL,
  address VARCHAR(250) DEFAULT NULL,
  city VARCHAR(250) DEFAULT NULL,
  dt_started date DEFAULT NULL,
  dt_stopped date DEFAULT NULL
);

DROP TABLE IF EXISTS client;

CREATE TABLE client (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  dt_received date DEFAULT NULL,
  nationality VARCHAR(250) DEFAULT NULL,
  address VARCHAR(250) DEFAULT NULL,
  city VARCHAR(250) DEFAULT NULL,
  start_booking date DEFAULT NULL,
  end_booking date DEFAULT NULL
);

DROP TABLE IF EXISTS motorcycle;

CREATE TABLE motorcycle (
  licence_plate VARCHAR(250) NOT NULL PRIMARY KEY,
  model VARCHAR(250) NOT NULL,
  model_year date DEFAULT NULL,
  kilometers INT,
  capability_seat INT
);

DROP TABLE IF EXISTS taxi;

CREATE TABLE taxi (
  licence_plate VARCHAR(250) NOT NULL PRIMARY KEY,
  model VARCHAR(250) NOT NULL,
  model_year date DEFAULT NULL,
  kilometers INT,
  capability_seat INT
);

DROP TABLE IF EXISTS minivan;

CREATE TABLE minivan (
  licence_plate VARCHAR(250) NOT NULL PRIMARY KEY,
  model VARCHAR(250) NOT NULL,
  model_year date DEFAULT NULL,
  kilometers INT,
  capability_seat INT
);
