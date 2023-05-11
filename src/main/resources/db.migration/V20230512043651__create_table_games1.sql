CREATE TABLE games
(
    name        VARCHAR,
    description VARCHAR,
    id          SERIAL
        CONSTRAINT games_pk
            PRIMARY KEY
);