package com.banksimulation.bank_simulation.Exceptions;

public class NoAccountFoundException extends RuntimeException {
    public NoAccountFoundException() {
        super("Nenhuma conta encontrada na base de dados.");
    }
}
