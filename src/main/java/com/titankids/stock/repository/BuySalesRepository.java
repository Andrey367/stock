package com.titankids.stock.repository;

import com.titankids.stock.model.report.BuySalesReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuySalesRepository extends JpaRepository<BuySalesReport, Long> {
}
