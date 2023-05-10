package com.titankids.stock.repository;

import com.titankids.stock.model.Gameconsole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GameconsoleRepository extends JpaRepository<Gameconsole, Long> {
    Gameconsole findByName(String name);
    Gameconsole findByDescription(String description);

}