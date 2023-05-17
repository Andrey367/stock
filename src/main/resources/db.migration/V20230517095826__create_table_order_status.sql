CREATE TABLE order_status
(
    name        VARCHAR,
    description VARCHAR,
    id          SERIAL
        CONSTRAINT order_status_pk
            PRIMARY KEY
);