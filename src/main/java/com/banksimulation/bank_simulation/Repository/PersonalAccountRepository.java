package com.banksimulation.bank_simulation.Repository;

import com.banksimulation.bank_simulation.DTO.PersonalAccountResponseDTO;
import com.banksimulation.bank_simulation.Entity.PersonalAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface PersonalAccountRepository extends JpaRepository<PersonalAccount, UUID> {

    boolean existsBy(String cpf);
}
