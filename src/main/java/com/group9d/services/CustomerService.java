package com.group9d.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group9d.models.Customer;
import com.group9d.models.CustomerRepository;

@Service
@Transactional
public class CustomerService {

    @Autowired
    private CustomerRepository repo;

    public List<Customer> listAll() {
      return repo.findAll();
    }

    public void save(Customer customer) {
      repo.save(customer);
    }

    public Customer get(Integer id) {
      return repo.findById(id).get();
    }

    public void delete (Integer id) {
      repo.deleteById(id);
    }
}
