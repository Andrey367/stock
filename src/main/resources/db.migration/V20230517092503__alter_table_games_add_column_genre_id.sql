alter table game_shop.games
    add genre_id integer;

alter table game_shop.games
    add constraint game_genre_fk
        foreign key (genre_id) references game_shop.genre;