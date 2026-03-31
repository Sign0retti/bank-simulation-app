package com.banksimulation.bank_simulation.service.impl;

import com.banksimulation.bank_simulation.DTO.PersonalAccountMapper;
import com.banksimulation.bank_simulation.DTO.PersonalAccountRequestDTO;
import com.banksimulation.bank_simulation.DTO.PersonalAccountResponseDTO;
import com.banksimulation.bank_simulation.Entity.PersonalAccount;
import com.banksimulation.bank_simulation.Exceptions.AccountTypeMandatoryException;
import com.banksimulation.bank_simulation.Exceptions.CpfExistenteException;
import com.banksimulation.bank_simulation.Repository.PersonalAccountRepository;
import com.banksimulation.bank_simulation.service.PersonalAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PersonalAccountServiceImpl implements PersonalAccountService {

    private final PersonalAccountRepository personalAccountRepository;
    private final PersonalAccountMapper mapper;

    @Override
    public PersonalAccountResponseDTO openAccount(PersonalAccountRequestDTO DTO){
        PersonalAccount account = mapper.toEntity(DTO);
            validateAccount(account);
            PersonalAccount saved = personalAccountRepository.save(account);
            return mapper.toResponse(saved);
    }

    private void validateAccount(PersonalAccount account){
        if(personalAccountRepository.existsBy(account.getCpf())){
            throw new CpfExistenteException();
        }
        if(account.getAccountType() == null){
            throw new AccountTypeMandatoryException();
        }

    }

}
