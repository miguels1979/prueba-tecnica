package com.tektonlabs.percentagecalculationapi.exceptions;

import com.tektonlabs.percentagecalculationapi.common.StandarizedApiExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProviderUnavailableException.class)
    public ResponseEntity<?> handleProviderUnavailable(ProviderUnavailableException ex){
        StandarizedApiExceptionResponse standarizedApiExceptionResponse =
                new StandarizedApiExceptionResponse("TÉCNICO", "Proveedor no disponible", "503", ex.getMessage());
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(standarizedApiExceptionResponse);
    }

}
