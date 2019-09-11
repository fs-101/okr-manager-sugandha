package com.xebia.okr.repository;

import com.xebia.okr.domain.KeyResult;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface KeyResultRepository extends CrudRepository<KeyResult, Long> {
    List<KeyResult> findByTitle(String name);
}
