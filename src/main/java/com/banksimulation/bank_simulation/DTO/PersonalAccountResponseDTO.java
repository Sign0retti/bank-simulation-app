package com.banksimulation.bank_simulation.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record PersonalAccountResponseDTO(

        UUID id,
        String accountNumber,
        String fullName,
        String cpf,
        String email,
        String phone,
        BigDecimal balance,
        BigDecimal overdraftLimit,
        String accountType,
        LocalDateTime createdAt
) {}


