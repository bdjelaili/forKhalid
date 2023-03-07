package org.louakfaoui.jpa.repository;

import org.louakfaoui.jpa.entity.Starship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StarshipRepository extends JpaRepository<Starship, Long> {
}
