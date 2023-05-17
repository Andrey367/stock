package com.titankids.stock.repository;

import com.titankids.stock.model.Client;
import com.titankids.stock.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderStatusRepository extends JpaRepository<OrderStatus, Long> {
}

