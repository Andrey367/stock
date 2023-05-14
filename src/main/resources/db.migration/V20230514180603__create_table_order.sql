CREATE TABLE game_shop."order"
(
    created_at TIMESTAMP,
    client_id  SERIAL,
    game_id    SERIAL,
    comment    VARCHAR,
    id          SERIAL
        CONSTRAINT order_pk
            PRIMARY KEY
);