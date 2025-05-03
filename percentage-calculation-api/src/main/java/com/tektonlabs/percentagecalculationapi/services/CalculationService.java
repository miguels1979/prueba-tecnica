package com.tektonlabs.percentagecalculationapi.services;

import org.springframework.stereotype.Service;

import java.net.UnknownHostException;

@Service
public class CalculationService {

    private final PercentageService percentageService;

    public CalculationService(PercentageService percentageService) {
        this.percentageService = percentageService;
    }

    public double calculate(double num1, double num2) {
        double percentage = percentageService.getPercentageFromProvider();
        return (num1 + num2) * (1 + percentage / 100);
    }

}

