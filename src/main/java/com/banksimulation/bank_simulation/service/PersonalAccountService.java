package com.banksimulation.bank_simulation.service;

import com.banksimulation.bank_simulation.DTO.PersonalAccountRequestDTO;
import com.banksimulation.bank_simulation.DTO.PersonalAccountResponseDTO;
import com.banksimulation.bank_simulation.Repository.PersonalAccountRepository;

public interface PersonalAccountService {
    PersonalAccountResponseDTO openAccount(PersonalAccountRequestDTO dto);
}
