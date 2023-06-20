package com.titankids.stock.repository;

import com.titankids.stock.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    @Query(value = "SELECT g FROM Game g " +
            "WHERE LOWER(g.name) LIKE %:keyword% " +
            "OR LOWER(g.description) LIKE %:keyword% " +
            "OR CONCAT(g.price, '') LIKE %:keyword% " +
            "OR CONCAT(g.changePrice, '') LIKE %:keyword% ")
    List<Game> filterBy(@Param("keyword") String keyword);
}
