package com.tektonlabs.percentagecalculationapi.services;


import com.tektonlabs.percentagecalculationapi.dtos.HistoryDto;
import com.tektonlabs.percentagecalculationapi.entities.HistoryEntity;
import com.tektonlabs.percentagecalculationapi.repositories.HistoryRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    public List<HistoryDto> getHistoryDto(){
        Iterable<HistoryEntity> entities = historyRepository.findAll();
        List<HistoryDto> dtos =  new ArrayList<>();

        for(HistoryEntity entity : entities){
            dtos.add(new HistoryDto(
                    entity.getDate(),
                    entity.getEndPoint(),
                    entity.getParameters(),
                    entity.getResponse()
            ));
        }
        return dtos;
    }

}
