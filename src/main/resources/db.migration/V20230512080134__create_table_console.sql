CREATE TABLE console
(
    name        VARCHAR,
    description VARCHAR,
    id          SERIAL
        CONSTRAINT console_pk
            PRIMARY KEY
);