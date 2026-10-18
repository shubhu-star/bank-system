package com.bank.controller;

import java.util.List;
import io.swagger.v3.oas.annotations.tags.Tag;
//import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import com.bank.entity.Account;
import com.bank.service.AccountService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/accounts")
@Tag(name="Account APIs",description="APIs for Bank MAnagement")

public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // CREATE
    @PostMapping
    @Operation(summary = "Create a new account")
    @ApiResponse(responseCode = "200", description = "Account created successfully")
    public Account createAccount(@Valid @RequestBody Account account) {
		return accountService.createAccount(account);
	}

    // GET BY ID
    @Operation(summary = "Get account by id")
    @ApiResponse(responseCode = "200", description = "Account found")
    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Long id) {
        return accountService.getAccountById(id);
    }

    // GET ALL
    @GetMapping
    @Operation(summary = "Get All account")
    @ApiResponse(responseCode = "200", description = "Account retrive sucessfully")
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    // UPDATE
    @PutMapping("/{id}")
    @Operation(summary = "Update account")
    @ApiResponse(responseCode = "200", description = "Account update successfully")
    public Account updateAccount(
            @PathVariable Long id,
            @RequestBody Account account) {

        return accountService.updateAccount(id, account);
    }

    // DELETE
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete account")
    @ApiResponse(responseCode = "200", description = "Account deleted successfully")
    public String deleteAccount(@PathVariable Long id) {

        accountService.deleteAccount(id);

        return "Account deleted successfully";
    }
        
 
   
}