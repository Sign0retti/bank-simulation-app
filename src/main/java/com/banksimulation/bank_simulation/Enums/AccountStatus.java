package com.banksimulation.bank_simulation.Enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum AccountStatus {

    ACTIVE("Active", "Account is active and operational"),
    INACTIVE("Inactive", "Account is inactive due to inactivity"),
    BLOCKED("Blocked", "Account is blocked due to suspicious activity or request"),
    CLOSED("Closed", "Account has been permanently closed");

    private final String displayName;
    private final String description;

}
