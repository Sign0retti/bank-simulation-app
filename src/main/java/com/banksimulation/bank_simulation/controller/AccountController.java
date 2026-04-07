package com.banksimulation.bank_simulation.controller;


import com.banksimulation.bank_simulation.DTO.PersonalAccountRequestDTO;
import com.banksimulation.bank_simulation.DTO.PersonalAccountResponseDTO;
import com.banksimulation.bank_simulation.service.PersonalAccountService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final PersonalAccountService personalAccountService;


    @GetMapping()
    public ResponseEntity<List<PersonalAccountResponseDTO>> listAccounts() {
        List<PersonalAccountResponseDTO> response = personalAccountService.listAccounts();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/newaccount")
    public ResponseEntity<PersonalAccountResponseDTO> openAccount(@RequestBody @Valid PersonalAccountRequestDTO dto) {
        PersonalAccountResponseDTO response = personalAccountService.openAccount(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        personalAccountService.deleteAccount(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonalAccountResponseDTO> listByID(@PathVariable Long id){
        PersonalAccountResponseDTO response = personalAccountService.accountByID(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
