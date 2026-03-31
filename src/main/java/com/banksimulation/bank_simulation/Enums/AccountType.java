package com.banksimulation.bank_simulation.Enums;

import com.banksimulation.bank_simulation.Exceptions.InvalidAccountTypeException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

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
        throw new InvalidAccountTypeException();
    }
}
