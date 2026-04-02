package com.banksimulation.bank_simulation.Handler;

import com.banksimulation.bank_simulation.Exceptions.*;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


    @RestControllerAdvice
    public class GlobalExceptionHandler {

        @ExceptionHandler(InvalidAccountTypeException.class)
        public ResponseEntity<String> handleInvalidAccountType(InvalidAccountTypeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }

        @ExceptionHandler(CpfExistenteException.class)
        public ResponseEntity<String> handleCpfExistente(CpfExistenteException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }

        @ExceptionHandler(EmailExistenteException.class)
        public ResponseEntity<String> handleEmailExistente(EmailExistenteException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }


        @ExceptionHandler(NoAccountFoundException.class)
        public ResponseEntity<String> handleNoAccountFound(NoAccountFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }

        @ExceptionHandler(AccountHasBalanceException.class)
        public ResponseEntity<String> handleAccountHasBalance(AccountHasBalanceException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }

    }