CREATE TABLE games
(
    name        VARCHAR,
    games_console VARCHAR,
    description VARCHAR,
    preview_link VARCHAR,
    id          SERIAL
        CONSTRAINT games_pk
            PRIMARY KEY
);