package org.louakfaoui.jpa.repository;

import org.louakfaoui.jpa.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {
}
