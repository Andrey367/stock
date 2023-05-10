package com.titankids.stock.repository;

import com.titankids.stock.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    Genre findByName(String name);
    Genre findByDescription(String description);
}