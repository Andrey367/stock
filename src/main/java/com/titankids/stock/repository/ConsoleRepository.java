package com.titankids.stock.repository;

import com.titankids.stock.model.Console;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ConsoleRepository extends JpaRepository<Console, Long> {
    Console findByName(String name);
    Console findByDescription(String description);

}