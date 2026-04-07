package com.banksimulation.bank_simulation.Repository;

import com.banksimulation.bank_simulation.Entity.PersonalAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<PersonalAccount, Long> {

    boolean existsBy(String cpf);

}
