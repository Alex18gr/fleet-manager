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
  id INT AUTO_INCREMENT  PRIMARY KEY,
  type VARCHAR(250) NOT NULL,
  licence_plate VARCHAR(250) NOT NULL UNIQUE,
  model VARCHAR(250) NOT NULL,
  model_year date DEFAULT NULL,
  kilometers INT,
  capability_seat INT,
  auto VARCHAR(10)
);

DROP TABLE IF EXISTS taxi;

CREATE TABLE taxi (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  type VARCHAR(250) NOT NULL,
  licence_plate VARCHAR(250) NOT NULL UNIQUE,
  model VARCHAR(250) NOT NULL,
  model_year date DEFAULT NULL,
  kilometers INT,
  capability_seat INT,
  weight double
);

DROP TABLE IF EXISTS minivan;

CREATE TABLE minivan (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  type VARCHAR(250) NOT NULL,
  licence_plate VARCHAR(250) NOT NULL UNIQUE,
  model VARCHAR(250) NOT NULL,
  model_year date DEFAULT NULL,
  kilometers INT,
  capability_seat INT,
  color VARCHAR(20)
);


DROP TABLE IF EXISTS route;

CREATE TABLE route (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  employee_id INT,
  client_id INT,
  minivan_id INT,
  motorcycle_id INT,
  taxi_id INT,
  destination VARCHAR(250),
  FOREIGN KEY (employee_id) REFERENCES employee(id),
  FOREIGN KEY (client_id) REFERENCES client(id),
  FOREIGN KEY (minivan_id) REFERENCES minivan(id),
  FOREIGN KEY (motorcycle_id) REFERENCES motorcycle(id),
  FOREIGN KEY (taxi_id) REFERENCES taxi(id)
);
