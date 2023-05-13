package com.titankids.stock.repository;

import com.titankids.stock.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    Game findByName(String name);
    Game findByDescription(String description);
    Game findByPrice (Double price);
}
