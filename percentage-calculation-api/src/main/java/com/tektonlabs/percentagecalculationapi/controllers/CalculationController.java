package com.tektonlabs.percentagecalculationapi.controllers;

import com.tektonlabs.percentagecalculationapi.services.CalculationService;
import com.tektonlabs.percentagecalculationapi.services.HistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
public class CalculationController {

    private final CalculationService calculationService;

    private final HistoryService historyService;

    public CalculationController(CalculationService calculationService, HistoryService historyService) {
        this.calculationService = calculationService;
        this.historyService = historyService;
    }

    @GetMapping("/calculate")
    public ResponseEntity<?> calculate (@RequestParam double num1, @RequestParam double num2){

        String parameters = String.valueOf(num1).concat(",").concat(String.valueOf(num2));
        try{
            double result = calculationService.calculate(num1,num2);
            historyService.saveHistory(LocalDateTime.now(),"/calculate"
                    , parameters, String.valueOf(result));
            return ResponseEntity.ok(result);
        } catch (Exception e){
            historyService.saveHistory(LocalDateTime.now(),"/calculate"
                    , parameters, "Error: ".concat(e.getMessage()));
            return ResponseEntity.status(500).body("error");
        }
    }

    @GetMapping("/history")
    public ResponseEntity<?> getHistory(){
        return ResponseEntity.ok(historyService.getHistory());
    }




}
