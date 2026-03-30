package com.banksimulation.bank_simulation.Exceptions;

public class EmailExistenteException extends RuntimeException {
    public EmailExistenteException() {
        super("E-mail informado já cadastrado!");
    }
}
