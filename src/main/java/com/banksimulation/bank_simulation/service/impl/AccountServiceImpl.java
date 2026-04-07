package com.banksimulation.bank_simulation.service.impl;

import com.banksimulation.bank_simulation.DTO.AccountMapper;
import com.banksimulation.bank_simulation.DTO.AccountRequestDTO;
import com.banksimulation.bank_simulation.DTO.AccountResponseDTO;
import com.banksimulation.bank_simulation.Entity.PersonalAccount;
import com.banksimulation.bank_simulation.Enums.AccountStatus;
import com.banksimulation.bank_simulation.Exceptions.AccountHasBalanceException;
import com.banksimulation.bank_simulation.Exceptions.AccountTypeMandatoryException;
import com.banksimulation.bank_simulation.Exceptions.CpfExistenteException;
import com.banksimulation.bank_simulation.Exceptions.NoAccountFoundException;
import com.banksimulation.bank_simulation.Repository.AccountRepository;
import com.banksimulation.bank_simulation.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository personalAccountRepository;
    private final AccountMapper mapper;

    @Override
    public AccountResponseDTO openAccount(AccountRequestDTO DTO){
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
    public List<AccountResponseDTO> listAccounts() {
        List<PersonalAccount> accounts = personalAccountRepository.findAll();
        List<AccountResponseDTO> response = new ArrayList<>();

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


    @Override
    public AccountResponseDTO accountByID(Long id){
        PersonalAccount account = personalAccountRepository.findById(id)
                .orElseThrow(NoAccountFoundException::new);
        return mapper.toResponse(account);
    }

}
