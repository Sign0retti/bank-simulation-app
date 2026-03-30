package com.banksimulation.bank_simulation.Exceptions;

public class AccountTypeException extends RuntimeException {
    public AccountTypeException() {
        super("Tipo de conta é obrigatorio.");
    }
}
