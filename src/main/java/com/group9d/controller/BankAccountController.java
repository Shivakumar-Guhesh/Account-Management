package com.group9d.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.group9d.models.BankAccount;
import com.group9d.services.BankAccountService;

@RestController
public class BankAccountController {
    @Autowired
    private BankAccountService bankAccountService;

    // RESTful API methods for Retrieval operations
    @GetMapping("/BankAccounts")
    public List<BankAccount> list() {
      return bankAccountService.listAll();
    }

    @GetMapping("/BankAccounts/{id}")
    public ResponseEntity<BankAccount> get(@PathVariable int id) {
      try {
        BankAccount bankAccount = bankAccountService.get(id);
        return new ResponseEntity<BankAccount>(bankAccount, HttpStatus.OK);
      } catch (NoSuchElementException e) {
        return new ResponseEntity<BankAccount>(HttpStatus.NOT_FOUND);
      }
    }

    // RESTful API method for Create operation
    @PostMapping("/BankAccounts")
    public void add(@RequestBody BankAccount BankAccount) {
      bankAccountService.save(BankAccount);
    }

    // RESTful API method for Update operation
    @PutMapping("/BankAccounts/{id}")
    public ResponseEntity<?> update(@RequestBody BankAccount BankAccount, @PathVariable int id) {
      try {
        BankAccount existBankAccount = bankAccountService.get(id);
        bankAccountService.save(BankAccount);
        return new ResponseEntity<>(HttpStatus.OK);
      } catch (NoSuchElementException e) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }

    // RESTful API method for Delete operation
    @DeleteMapping("/BankAccounts/{id}")
    public void delete (@PathVariable Integer id) {
      bankAccountService.delete(id);
    }
}
