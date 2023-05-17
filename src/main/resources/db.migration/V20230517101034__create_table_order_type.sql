CREATE TABLE order_type
(
    name        VARCHAR,
    description VARCHAR,
    id          SERIAL
        CONSTRAINT order_type_pk
            PRIMARY KEY
);