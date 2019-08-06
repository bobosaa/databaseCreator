DROP TABLE IF EXISTS      own;
DROP TABLE IF EXISTS      owners;
DROP SEQUENCE IF EXISTS   hibernate_sequence;
DROP SEQUENCE IF EXISTS   id_sequence;


CREATE SEQUENCE
  hibernate_sequence INCREMENT BY 100000 START WITH 100000;
CREATE SEQUENCE
  id_sequence INCREMENT BY 1 START WITH 1;


CREATE TABLE owners (
  id             BIGINT DEFAULT nextval('id_sequence') PRIMARY KEY,
  owners_name    VARCHAR(64) NOT NULL,
  birthday       TIMESTAMP NOT NULL
);


CREATE TABLE own (
  id            BIGINT DEFAULT nextval('id_sequence') PRIMARY KEY,
  own_name      VARCHAR(64) NOT NULL,
  owners_id     BIGINT NOT NULL,
  type          VARCHAR(64) NOT NULL,
  price         BIGINT NOT NULL,
  FOREIGN KEY (owners_id) REFERENCES Owners(id)
);


INSERT INTO owners (owners_name, birthday) VALUES
  ('Pirozhkov Petr Stanislavovich','1991-06-19 20:10:11'),
  ('Yelchukov Danya Fyodorovich','2001-07-12 13:59:24'),
  ('Chukchov Rollan Vadimovich','1980-02-22 06:15:25'),
  ('Rytin Elie Tarasovich','1993-03-31 03:25:16'),
  ('Noskov Rustem Savelievich','2002-06-16 15:11:17');


INSERT INTO own (own_name, owners_id, type, price)  VALUES
  ('car','1', 'moveble',nextval('hibernate_sequence')),
  ('car','2', 'moveble',nextval('hibernate_sequence')),
  ('flat','3', 'unmoveble',nextval('hibernate_sequence')),
  ('flat','4', 'unmoveble',nextval('hibernate_sequence')),
  ('house','5', 'unmoveble',nextval('hibernate_sequence')),
  ('house','1', 'unmoveble',nextval('hibernate_sequence')),
  ('house','2', 'unmoveble',nextval('hibernate_sequence'));

