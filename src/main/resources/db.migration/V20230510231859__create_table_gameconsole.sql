CREATE TABLE gameconsole
(
    name        VARCHAR,
    description VARCHAR,
    id          SERIAL
        CONSTRAINT gameconsole_pk
            PRIMARY KEY
);