package org.web.springlamiapizzeriacrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.web.springlamiapizzeriacrud.model.Offer;

public interface OfferRepository extends JpaRepository<Offer, Integer> {
}
