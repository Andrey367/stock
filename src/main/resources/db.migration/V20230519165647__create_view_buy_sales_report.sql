drop view if exists buy_sales_report;
create view buy_sales_report as

select row_number() over (order by month) id, month, sum(t.buys) buy, sum(t.sales) sale from
    (

        select case when o.order_type_id = 1 then (o.price * o.amount) else 0 end as buys,
               case when o.order_type_id = 2 then (o.price * o.amount) else 0 end as sales,
               date_part('Month', o.created_at) as month
        from "order" o
    ) t
group by t.month