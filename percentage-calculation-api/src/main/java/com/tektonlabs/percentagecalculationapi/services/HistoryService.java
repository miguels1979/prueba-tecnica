package com.tektonlabs.percentagecalculationapi.services;


import com.tektonlabs.percentagecalculationapi.entities.HistoryEntity;
import com.tektonlabs.percentagecalculationapi.repositories.HistoryRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class HistoryService {

    private final  HistoryRepository historyRepository;

    public HistoryService(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Async
    public void saveHistory(LocalDateTime date, String endPoint, String parameters, String response){
        HistoryEntity historyEntity = new HistoryEntity(date, endPoint, parameters, response);
        historyRepository.save(historyEntity);
    }

    public Iterable<HistoryEntity> getHistory(){
        return historyRepository.findAll();
    }

}
