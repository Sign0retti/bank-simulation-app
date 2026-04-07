package com.banksimulation.bank_simulation.controller;


import com.banksimulation.bank_simulation.DTO.AccountRequestDTO;
import com.banksimulation.bank_simulation.DTO.AccountResponseDTO;
import com.banksimulation.bank_simulation.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService personalAccountService;


    @GetMapping
    public ResponseEntity<List<AccountResponseDTO>> listAccounts() {
        List<AccountResponseDTO> response = personalAccountService.listAccounts();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<AccountResponseDTO> openAccount(@RequestBody @Valid AccountRequestDTO dto) {
        AccountResponseDTO response = personalAccountService.openAccount(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        personalAccountService.deleteAccount(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountResponseDTO> listByID(@PathVariable Long id){
        AccountResponseDTO response = personalAccountService.accountByID(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
