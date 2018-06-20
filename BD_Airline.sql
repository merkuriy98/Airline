CREATE TABLE users (
  id         SERIAL PRIMARY KEY,
  role_name  varchar(255) not Null,
  first_name VARCHAR(255) NOT NULL,
  last_name  VARCHAR(255) NOT NULL,
  login      VARCHAR(255) NOT NULL,
  birthday   DATE NOT NULL,
  phone      CHAR(13)    NOT NULL,
  password   VARCHAR(255)    NOT NULL
);

CREATE TABLE employes (
  id         SERIAL PRIMARY KEY,
  first_name VARCHAR(255) NOT NULL,
  last_name  VARCHAR(255) NOT NULL,
  type_name  varchar(255) not null
);

CREATE TABLE planes (
  id    SERIAL PRIMARY KEY,
  name  VARCHAR(255) NOT NULL,
  model VARCHAR(255) NOT NULL
);

CREATE TABLE airports (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  city VARCHAR(255) NOT NULL,
  country VARCHAR(255) NOT NULL
);

CREATE TABLE flights (
  id serial primary key,
  number_flight INT NOT null unique,
  id_plane INT NOT NULL,
  departure_airport INT NOT NULL,
  arrival_aiport INT NOT NULL,
  date timestamp NOT NULL,
  status varchar(255) NOT NULL,
  FOREIGN KEY (id_plane) REFERENCES planes (id),
  FOREIGN KEY (departure_airport) REFERENCES airports(id),
  FOREIGN KEY (arrival_aiport) REFERENCES airports(id)
);

CREATE TABLE flights_employes (
  id_flight  INT not null,
  id_employee    INT not null,
   FOREIGN KEY (id_flight) REFERENCES flights (id),
  FOREIGN KEY (id_employee) REFERENCES employes (id)
);



INSERT INTO users (role_name,first_name, last_name, login, birthday, phone, password)
VALUES ('ADMIN','Roma', 'Merkulov', 'roma24', '1998-07-24', '+38123456789', '0000');

INSERT INTO employes (first_name, last_name, type_name)
VALUES ('Александр', 'Макаренко','PILOT'),
('Дмитрий', 'Таранов', 'PILOT'),
('Игорь', 'Бабенко', 'RADIOMAN'), ('Евгений', 'Муский','RADIOMAN'),
('Артур', 'Сердюк','NAVIGATOR'), ('Николай', 'Соболев','NAVIGATOR'),
('Анна', 'Сокол','HOSTESS'), ('Виктория', 'Домбровская','HOSTESS');

INSERT INTO planes (name, model) VALUES
  ('Airbus', 'A32neo'), ('Boeing', '737MAX');

INSERT INTO airports (name, city, country) VALUES
  ('Kharkiv airport', 'Харьков', 'Украина'), 
  ('Boryspil airport', 'Борисполь', 'Украина'),
  ('Stambul airport', 'Стамбул', 'Турция');

INSERT INTO flights (number_flight, id_plane, departure_airport, arrival_aiport, date, status)
VALUES ('826', 1, 1, 3, timestamp '2018-06-16 18:38:00', 'CLOSE');
 
INSERT INTO flights_employes (id_flight, id_employee)
VALUES (1, 1),(1,2),(1,3),(1,4);


