package com.umitakblut.weather.exception;

import com.umitakblut.weather.exception.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(WeatherException.class)
    public ResponseEntity<?> authorizationExceptionHandler(WeatherException userException){
        return new ResponseEntity<ErrorDTO>(new ErrorDTO(userException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value(), userException.getKey()),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
