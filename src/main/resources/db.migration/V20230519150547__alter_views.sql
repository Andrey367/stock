drop view sales_by_month;
create view sales_by_month as
SELECT row_number() OVER (ORDER BY s.month) AS id,
       s.month,
       sum(s.sales)                         AS sale
FROM (SELECT sum(o.price * o.amount::double precision) AS sales,
             date_part('month'::text, o.created_at)    AS month
      FROM game_shop."order" o
      WHERE o.order_type_id = 2
      GROUP BY o.created_at) s
GROUP BY s.month;

drop view sales_by_genre;
create view sales_by_genre as
SELECT row_number() OVER (ORDER BY g2.name)      AS id,
       g2.name                                   AS genre,
       sum(o.price * o.amount::double precision) AS sale
FROM game_shop."order" o
         LEFT JOIN game_shop.games g ON o.game_id = g.id
         LEFT JOIN game_shop.genre g2 ON g.genre_id = g2.id
WHERE o.order_status_id = 3
  AND o.order_type_id = 2
GROUP BY g2.name;