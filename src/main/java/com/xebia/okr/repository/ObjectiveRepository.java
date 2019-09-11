package com.xebia.okr.repository;

import com.xebia.okr.domain.Objective;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ObjectiveRepository extends CrudRepository<Objective, Long> {
    List<Objective> findByTitle(String name);
}
