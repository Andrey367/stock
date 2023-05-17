alter table game_shop."order"
    add order_status integer;

alter table game_shop."order"
    add constraint order_order_status_fk
        foreign key (order_status) references game_shop.order_status;