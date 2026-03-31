package com.banksimulation.bank_simulation.Exceptions;

public class AccountTypeMandatoryException extends RuntimeException {
    public AccountTypeMandatoryException() {
        super("Tipo de conta é obrigatorio.");
    }
}
