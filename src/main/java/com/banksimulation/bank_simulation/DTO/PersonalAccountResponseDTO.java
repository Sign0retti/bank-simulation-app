package com.banksimulation.bank_simulation.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PersonalAccountResponseDTO(

        String accountNumber,
        String fullName,
        String cpf,
        String email,
        BigDecimal balance,
        BigDecimal overdraftLimit,
        String accountType,
        LocalDateTime createdAt
) {}


