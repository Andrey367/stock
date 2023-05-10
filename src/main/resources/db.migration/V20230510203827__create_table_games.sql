CREATE TABLE games
(
    name        VARCHAR,
    game_console VARCHAR,
    description VARCHAR,
    preview_link VARCHAR,
    id          SERIAL
        CONSTRAINT genre_pk
            PRIMARY KEY
);