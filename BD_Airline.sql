CREATE TABLE users (
  id         SERIAL PRIMARY KEY,
  first_name VARCHAR(20) NOT NULL,
  last_name  VARCHAR(32) NOT NULL,
  login      VARCHAR(20) NOT NULL,
  birthday   DATE        NOT NULL,
  phone      CHAR(12)    NOT NULL,
  password   CHAR(32)    NOT NULL
);

CREATE TABLE admins (
  id         SERIAL PRIMARY KEY,
  first_name VARCHAR(20) NOT NULL,
  last_name  VARCHAR(32) NOT NULL,
  login      VARCHAR(20) NOT NULL,
  password   CHAR(32)    NOT NULL
);

CREATE TABLE pilots (
  id         SERIAL PRIMARY KEY,
  first_name VARCHAR(20) NOT NULL,
  last_name  VARCHAR(32) NOT NULL,
  status     BOOLEAN     NOT NULL
);

CREATE TABLE navigators (
  id         SERIAL PRIMARY KEY,
  first_name VARCHAR(20) NOT NULL,
  last_name  VARCHAR(32) NOT NULL,
  status     BOOLEAN     NOT NULL
);

CREATE TABLE radiomans (
  id         SERIAL PRIMARY KEY,
  first_name VARCHAR(20) NOT NULL,
  last_name  VARCHAR(32) NOT NULL,
  status     BOOLEAN     NOT NULL
);

CREATE TABLE brigades (
  id          SERIAL PRIMARY KEY,
  id_pilot    INT NOT NULL,
  id_navigatr INT NOT NULL,
  id_radioman INT NOT NULL,
  id_hostes   INT NOT NULL,
  FOREIGN KEY (id_pilot) REFERENCES pilots (id),
  FOREIGN KEY (id_navigatr) REFERENCES navigators (id),
  FOREIGN KEY (id_radioman) REFERENCES radiomans (id),
  FOREIGN KEY (id_hostes) REFERENCES hostess (id)
);


CREATE TABLE planes (
  id    SERIAL PRIMARY KEY,
  name  VARCHAR(20) NOT NULL,
  model VARCHAR(20) NOT NULL
);

CREATE TABLE airports (
  id SERIAL PRIMARY KEY,
  name VARCHAR(20) NOT NULL,
  city VARCHAR(20) NOT NULL,
  country VARCHAR(20) NOT NULL
);

CREATE TABLE flights (
  number INT NOT NULL PRIMARY KEY,
  id_plane INT NOT NULL,
  departure_airport INT NOT NULL,
  arrival_aiport INT NOT NULL,
  date DATE NOT NULL,
  time TIME NOT NULL ,
  id_brigade INT NOT NULL ,
  status BOOLEAN NOT NULL,
  FOREIGN KEY (id_plane) REFERENCES planes (id),
  FOREIGN KEY (departure_airport) REFERENCES airports(id),
  FOREIGN KEY (arrival_aiport) REFERENCES airports(id),
  FOREIGN KEY (id_brigade) REFERENCES brigades(id)

)