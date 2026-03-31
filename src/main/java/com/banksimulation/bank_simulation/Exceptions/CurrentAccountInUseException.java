package com.banksimulation.bank_simulation.Exceptions;

public class CurrentAccountInUseException extends RuntimeException {
    public CurrentAccountInUseException() {
        super("O numero da conta corrente já existe.");
    }
}
