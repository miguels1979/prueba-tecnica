package com.tektonlabs.percentageprovider.services;

import org.springframework.stereotype.Service;

@Service
public class PercentageService {

    public double getPercentage() {
        return Math.random() * (90 - 15) + 15;
    }
}
