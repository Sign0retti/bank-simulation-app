package com.banksimulation.bank_simulation.service;

import com.banksimulation.bank_simulation.DTO.PersonalAccountRequestDTO;
import com.banksimulation.bank_simulation.DTO.PersonalAccountResponseDTO;

import java.util.List;

public interface PersonalAccountService {
    PersonalAccountResponseDTO openAccount(PersonalAccountRequestDTO dto);
    List<PersonalAccountResponseDTO> listAccounts();
    void deleteAccount(Long id);
    PersonalAccountResponseDTO accountByID(Long id);
}

