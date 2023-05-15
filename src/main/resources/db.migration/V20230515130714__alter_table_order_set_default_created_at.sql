alter table game_shop."order"
    alter column created_at set not null;

alter table game_shop."order"
    alter column created_at set default now();