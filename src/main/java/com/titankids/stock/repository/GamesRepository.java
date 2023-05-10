package com.titankids.stock.repository;

import com.titankids.stock.model.Games;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GamesRepository extends JpaRepository<Games, Long> {
    Games findByName(String name);
    Games findByGames_console (String games_console);
    Games findByDescription(String description);
    Games findByPreview_link (String preview_link);
}
