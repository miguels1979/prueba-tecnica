package com.tektonlabs.percentagecalculationapi;

import com.tektonlabs.percentagecalculationapi.services.CalculationService;
import com.tektonlabs.percentagecalculationapi.services.PercentageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalculationServiceTest {

    private PercentageService percentageService;
    private CalculationService calculationService;

    @BeforeEach
    public void setUp() {
        percentageService = mock(PercentageService.class);
        calculationService = new CalculationService(percentageService);
    }

    @Test
    public void testCalculate() {

        when(percentageService.getPercentageFromProvider()).thenReturn(10.0);
        double result = calculationService.calculate(100, 50);
        assertEquals(165.0, result);
    }

}
