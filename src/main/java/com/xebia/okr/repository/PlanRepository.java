package com.xebia.okr.repository;

import com.xebia.okr.domain.Plan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlanRepository extends CrudRepository<Plan, Long> {

    List<Plan> findByTitle(String title);

}
