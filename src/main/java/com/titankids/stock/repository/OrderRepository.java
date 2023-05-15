package com.titankids.stock.repository;

import com.titankids.stock.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value = "SELECT o FROM Order o ORDER BY o.createdAt")
    List<Order> findAllOrderByCreatedAt();
}