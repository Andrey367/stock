package com.titankids.stock.repository;

import com.titankids.stock.model.Client;
import com.titankids.stock.model.OrderType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderTypeRepository extends JpaRepository<OrderType, Long> {
}

