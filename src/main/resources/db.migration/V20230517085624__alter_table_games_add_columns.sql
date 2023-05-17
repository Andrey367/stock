alter table game_shop.games
    add changeable bool default false not null;

alter table game_shop.games
    add change_price numeric;