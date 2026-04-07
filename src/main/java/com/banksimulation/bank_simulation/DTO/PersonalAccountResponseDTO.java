package com.banksimulation.bank_simulation.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PersonalAccountResponseDTO(
        Long id,
        String fullName,
        String cpf,
        String email,
        String phone,
        BigDecimal balance,
        BigDecimal overdraftLimit,
        String accountType,
        String status,
        LocalDateTime createdAt
) {}


