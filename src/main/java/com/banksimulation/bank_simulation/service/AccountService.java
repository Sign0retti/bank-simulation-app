package com.banksimulation.bank_simulation.service;

import com.banksimulation.bank_simulation.DTO.AccountRequestDTO;
import com.banksimulation.bank_simulation.DTO.AccountResponseDTO;

import java.util.List;

public interface AccountService {
    AccountResponseDTO openAccount(AccountRequestDTO dto);
    List<AccountResponseDTO> listAccounts();
    void deleteAccount(Long id);
    AccountResponseDTO accountByID(Long id);
}

