package com.tektonlabs.percentagecalculationapi.controllers;

import com.tektonlabs.percentagecalculationapi.exceptions.ProviderUnavailableException;
import com.tektonlabs.percentagecalculationapi.services.CalculationService;
import com.tektonlabs.percentagecalculationapi.services.HistoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
@Tag(name = "Calculation", description = "Operaciones relacionadas con el porcentaje")
public class CalculationController {

    private final CalculationService calculationService;

    private final HistoryService historyService;

    public CalculationController(CalculationService calculationService, HistoryService historyService) {
        this.calculationService = calculationService;
        this.historyService = historyService;
    }
    @Operation(
            summary = "Calcular porcentaje",
            description = "Calcula el porcentaje entre dos números utilizando un valor proporcionado por otro microservicio"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Porcentaje calculado exitosamente"),
            @ApiResponse(responseCode = "500", description = "Error al obtener el porcentaje desde el proveedor")
    })
    @GetMapping("/calculate")
    public ResponseEntity<?> calculate ( @Parameter(description = "Primer número") @RequestParam double num1,
                                         @Parameter(description = "Segundo número") @RequestParam double num2){

        String parameters = String.valueOf(num1).concat(",").concat(String.valueOf(num2));
        try{
            double result = calculationService.calculate(num1,num2);
            historyService.saveHistory(LocalDateTime.now(),"/calculate"
                    , parameters, String.valueOf(result));
            return ResponseEntity.ok(result);
        } catch (Exception e){
            historyService.saveHistory(LocalDateTime.now(),"/calculate"
                    , parameters, "Error: ".concat(e.getMessage()));
            throw new ProviderUnavailableException(e.getMessage());

        }
    }
    @Operation(
            summary = "Obtener historial",
            description = "Devuelve el historial de cálculos realizados con parámetros y resultados"
    )
    @ApiResponse(responseCode = "200", description = "Historial obtenido correctamente")
    @GetMapping("/history")
    public ResponseEntity<?> getHistory(){
        return ResponseEntity.ok(historyService.getHistory());
    }
}
