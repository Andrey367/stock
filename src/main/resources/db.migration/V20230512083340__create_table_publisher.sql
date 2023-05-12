CREATE TABLE publisher
(
    name        VARCHAR,
    description VARCHAR,
    id          SERIAL
        CONSTRAINT publisher_pk
            PRIMARY KEY
);