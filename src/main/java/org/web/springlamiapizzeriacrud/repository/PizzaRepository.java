package org.web.springlamiapizzeriacrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.web.springlamiapizzeriacrud.model.Pizza;

import java.util.List;

public interface PizzaRepository extends JpaRepository<Pizza, Integer> {
    List<Pizza> findByDescriptionContaining(String search);
}
