package com.tektonlabs.percentagecalculationapi.repositories;

import com.tektonlabs.percentagecalculationapi.entities.HistoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface HistoryRepository extends CrudRepository<HistoryEntity, Long> {
}
