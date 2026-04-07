package com.banksimulation.bank_simulation.DTO;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;

public record AccountRequestDTO(

        @NotBlank(message = "Nome completo é obrigatório")
        String fullName,

        @NotBlank(message = "CPF é obrigatório")
        @CPF(message = "CPF inválido")
        String cpf,

        @NotBlank(message = "E-mail é obrigatório")
        @Email(message = "E-mail inválido")
        String email,

        @NotBlank(message = "Telefone é obrigatório")
        String phone,

        @NotNull(message = "Tipo de conta é obrigatório")
        Integer accountTypeCode,

        @NotNull(message = "Limite do cheque especial é obrigatório")
        @DecimalMin(value = "0.0", message = "Limite não pode ser negativo")
        BigDecimal overdraftLimit
) {}
