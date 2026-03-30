package com.banksimulation.bank_simulation.Exceptions;

public class CpfExistenteException extends RuntimeException {
    public CpfExistenteException() {
        super("O CPF informado já possui uma conta!");
    }
}
