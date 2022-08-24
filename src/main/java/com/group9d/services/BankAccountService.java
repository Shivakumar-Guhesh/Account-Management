package com.group9d.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group9d.models.BankAccount;
import com.group9d.models.BankAccountRepository;

@Service
@Transactional
public class BankAccountService {
    @Autowired
    private BankAccountRepository repo;

    public List<BankAccount> listAll() {
      return repo.findAll();
    }

    public void save(BankAccount bankAccount) {
      repo.save(bankAccount);
    }

    public BankAccount get(Integer id) {
      return repo.findById(id).get();
    }

    public void delete (Integer id) {
      repo.deleteById(id);
    }
}
