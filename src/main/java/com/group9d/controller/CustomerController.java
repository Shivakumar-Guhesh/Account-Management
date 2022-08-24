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

import com.group9d.models.Customer;
import com.group9d.services.CustomerService;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    // RESTful API methods for Retrieval operations
    @GetMapping("/Customers")
    public List<Customer> list() {
      return customerService.listAll();
    }

    @GetMapping("/Customers/{id}")
    public ResponseEntity<Customer> get(@PathVariable int id) {
      try {
        Customer Customer = customerService.get(id);
        return new ResponseEntity<Customer>(Customer, HttpStatus.OK);
      } catch (NoSuchElementException e) {
        return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
      }
    }

    // RESTful API method for Create operation
    @PostMapping("/Customers")
    public void add(@RequestBody Customer Customer) {
      customerService.save(Customer);
    }

    // RESTful API method for Update operation
    @PutMapping("/Customers/{id}")
    public ResponseEntity<?> update(@RequestBody Customer Customer, @PathVariable int id) {
      try {
        Customer existCustomer = customerService.get(id);
        customerService.save(Customer);
        return new ResponseEntity<>(HttpStatus.OK);
      } catch (NoSuchElementException e) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }

    // RESTful API method for Delete operation
    @DeleteMapping("/Customers/{id}")
    public void delete (@PathVariable Integer id) {
      customerService.delete(id);
    }
}
