package com.banksimulation.bank_simulation.service.impl;

import com.banksimulation.bank_simulation.DTO.PersonalAccountMapper;
import com.banksimulation.bank_simulation.DTO.PersonalAccountRequestDTO;
import com.banksimulation.bank_simulation.DTO.PersonalAccountResponseDTO;
import com.banksimulation.bank_simulation.Entity.PersonalAccount;
import com.banksimulation.bank_simulation.Enums.AccountStatus;
import com.banksimulation.bank_simulation.Exceptions.AccountHasBalanceException;
import com.banksimulation.bank_simulation.Exceptions.AccountTypeMandatoryException;
import com.banksimulation.bank_simulation.Exceptions.CpfExistenteException;
import com.banksimulation.bank_simulation.Exceptions.NoAccountFoundException;
import com.banksimulation.bank_simulation.Repository.PersonalAccountRepository;
import com.banksimulation.bank_simulation.service.PersonalAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<PersonalAccountResponseDTO> listAccounts() {
        List<PersonalAccount> accounts = personalAccountRepository.findAll();
        List<PersonalAccountResponseDTO> response = new ArrayList<>();

        if(accounts.isEmpty()){
            throw new NoAccountFoundException();
        }
            for (PersonalAccount account : accounts) {
                response.add(mapper.toResponse(account));
            }
            return response;
        }

    @Override
    public void deleteAccount(Long id) {
        PersonalAccount account = personalAccountRepository.findById(id)
                .orElseThrow(NoAccountFoundException::new);

        if (account.getBalance().compareTo(BigDecimal.ZERO) > 0) {
            throw new AccountHasBalanceException();
        }

        //Era pra ser um delete convencional, entretanto a IA me explicou que em sistemas bancários
        //é feito somente o 'soft-delete' para manter rastreabilidade e auditoria.

        account.setStatus(AccountStatus.CLOSED);
        account.setClosedAt(LocalDateTime.now());
        personalAccountRepository.save(account);

    }

}
