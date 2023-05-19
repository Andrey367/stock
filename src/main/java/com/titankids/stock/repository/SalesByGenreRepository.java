package com.titankids.stock.repository;

import com.titankids.stock.model.report.SalesByGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesByGenreRepository extends JpaRepository<SalesByGenre, Long> {
}
