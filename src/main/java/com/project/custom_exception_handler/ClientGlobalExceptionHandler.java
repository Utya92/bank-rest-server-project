package com.project.custom_exception_handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ClientGlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ClientIncorrectData> handleException(NoSuchClientException e) {
        ClientIncorrectData employeeIncorrectData
                = new ClientIncorrectData();
        employeeIncorrectData.setInfo(e.getMessage());

        return new ResponseEntity<>(employeeIncorrectData, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ClientIncorrectData> handleException(Exception e) {
        ClientIncorrectData employeeIncorrectData
                = new ClientIncorrectData();
        employeeIncorrectData.setInfo(e.getMessage());

        return new ResponseEntity<>(employeeIncorrectData, HttpStatus.BAD_REQUEST);
    }
}
