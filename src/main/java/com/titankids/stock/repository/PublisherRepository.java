package com.titankids.stock.repository;

import com.titankids.stock.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    Publisher findByName(String name);
    Publisher findByDescription(String description);
}