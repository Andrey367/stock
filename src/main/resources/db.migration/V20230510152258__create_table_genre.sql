CREATE TABLE genre
(
    name        VARCHAR,
    description VARCHAR,
    id          SERIAL
        CONSTRAINT genre_pk
            PRIMARY KEY
);