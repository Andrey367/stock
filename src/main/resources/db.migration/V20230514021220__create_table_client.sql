CREATE TABLE client (

  name VARCHAR(50) NOT NULL,
  telephone VARCHAR(18),
  email VARCHAR(50),
   id          SERIAL
          CONSTRAINT client_pk
              PRIMARY KEY
  );
