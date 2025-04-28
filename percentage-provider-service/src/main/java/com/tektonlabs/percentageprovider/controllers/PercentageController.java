package com.tektonlabs.percentageprovider.controllers;

import com.tektonlabs.percentageprovider.dtos.PercentageResponse;
import com.tektonlabs.percentageprovider.services.PercentageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PercentageController {

    private final PercentageService percentageService;

    public PercentageController(PercentageService percentageService) {
        this.percentageService = percentageService;
    }

    @GetMapping("/percentage")
    public PercentageResponse getPercentage() {
        double percentage = percentageService.getPercentage();
        return new PercentageResponse(percentage);
    }
}
