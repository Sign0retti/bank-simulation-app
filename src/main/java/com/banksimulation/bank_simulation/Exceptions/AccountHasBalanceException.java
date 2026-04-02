package com.banksimulation.bank_simulation.Exceptions;

public class AccountHasBalanceException extends RuntimeException {
    public AccountHasBalanceException() {
        super("Não é possível deletar uma conta com saldo.");
    }
}