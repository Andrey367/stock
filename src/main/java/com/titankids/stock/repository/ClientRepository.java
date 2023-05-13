package com.titankids.stock.repository;

import com.titankids.stock.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByName (String name);

    Client findByTelephone (String telephone);

    Client findByEmail (String email);
}

