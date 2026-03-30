package com.banksimulation.bank_simulation.Enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AccountType {

    FISICO(1, "Pessoa Física"),
    JURIDICO(2, "Pessoa Jurídica");

    private final int code;
    private final String displayName;


    public static AccountType fromCode(int code) {
        for (AccountType type : values()) {
            if (type.code == code) return type;
        }
        throw new IllegalArgumentException("Invalid account type code: " + code);
    }
}
