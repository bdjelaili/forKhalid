package org.louakfaoui.jpa.repository;

import org.louakfaoui.jpa.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<People, Long> {
}
