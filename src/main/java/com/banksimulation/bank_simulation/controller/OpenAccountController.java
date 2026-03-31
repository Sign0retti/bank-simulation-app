package com.banksimulation.bank_simulation.controller;


import com.banksimulation.bank_simulation.DTO.PersonalAccountRequestDTO;
import com.banksimulation.bank_simulation.DTO.PersonalAccountResponseDTO;
import com.banksimulation.bank_simulation.service.PersonalAccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class OpenAccountController {

    private final PersonalAccountService personalAccountService;

    @PostMapping("/newaccount")
    public ResponseEntity<PersonalAccountResponseDTO> openAccount(@RequestBody @Valid PersonalAccountRequestDTO dto) {
        PersonalAccountResponseDTO response = personalAccountService.openAccount(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
