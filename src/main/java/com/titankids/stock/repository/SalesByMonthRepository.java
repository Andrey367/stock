package com.titankids.stock.repository;

import com.titankids.stock.model.report.SalesByMonth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesByMonthRepository extends JpaRepository<SalesByMonth, Long> {
}
