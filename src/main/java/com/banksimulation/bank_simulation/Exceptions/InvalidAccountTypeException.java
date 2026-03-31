package com.banksimulation.bank_simulation.Exceptions;

public class InvalidAccountTypeException extends RuntimeException {
  public InvalidAccountTypeException() {
    super("Tipo de conta inválido. Use 1 para FISICO ou 2 para JURIDICO.");
  }
}