package com.banksimulation.bank_simulation.DTO;

import com.banksimulation.bank_simulation.Entity.PersonalAccount;
import com.banksimulation.bank_simulation.Enums.AccountType;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public PersonalAccount toEntity(AccountRequestDTO dto) {
        PersonalAccount account = new PersonalAccount();
        account.setFullName(dto.fullName());
        account.setCpf(dto.cpf());
        account.setEmail(dto.email());
        account.setPhone(dto.phone());
        account.setOverdraftLimit(dto.overdraftLimit());
        account.setAccountType(AccountType.fromCode(dto.accountTypeCode()));
        return account;
    }

    public AccountResponseDTO toResponse(PersonalAccount account) {
        return new AccountResponseDTO(
                account.getId(),
                account.getFullName(),
                account.getCpf(),
                account.getEmail(),
                account.getPhone(),
                account.getBalance(),
                account.getOverdraftLimit(),
                account.getAccountType().getDisplayName(),
                account.getStatus().getDisplayName(),
                account.getCreatedAt()
        );
    }
}
