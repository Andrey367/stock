alter table game_shop."order"
    add order_type_id integer;

alter table game_shop."order"
    add constraint order_order_type_fk
        foreign key (order_type_id) references game_shop.order_type (id);