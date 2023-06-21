package com.titankids.stock.repository;

import com.titankids.stock.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value = "SELECT o FROM Order o ORDER BY o.createdAt")
    List<Order> findAllOrderByCreatedAt();

    @Query(value = "SELECT o FROM Order o " +
            "WHERE to_char(o.createdAt, 'DD.MM.YYYY') LIKE %:keyword% " +
            "OR CONCAT(o.price, '') LIKE %:keyword% " +
            "OR LOWER(o.comment) LIKE %:keyword% " +
            "OR o.client.telephone LIKE %:keyword% ")
    List<Order> filterBy(@Param("keyword") String keyword);
}