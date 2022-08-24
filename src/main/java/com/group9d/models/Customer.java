package com.group9d.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {
    @Column(name = "CustomerID", columnDefinition = "int")
    int customerId;

    @Column(name = "PAN", columnDefinition = "varchar")
    String  pan ;

    @Column(name = "Aadhar", columnDefinition = "varchar")
    String  aadhar ;

    @Column(name = "Name", columnDefinition = "varchar")
    String  name  ;

    @Column(name = "Email", columnDefinition = "varchar")
    String  email ;

    @Column(name = "Phone", columnDefinition = "varchar")
    String  phone ;

    @Column(name = "DOB", columnDefinition = "DATE")
    String  dob ;

    @Column(name = "Address", columnDefinition = "varchar")
    String  address ;

    public Customer() {
    }

    public Customer(int customerId, String pan, String aadhar, String name, String email, String phone, String dob,
                    String address) {
      this.customerId = customerId;
      this.pan = pan;
      this.aadhar = aadhar;
      this.name = name;
      this.email = email;
      this.phone = phone;
      this.dob = dob;
      this.address = address;
    }

    @Id
    public int getCustomerId() {
      return customerId;
    }

    public void setCustomerId(int customerId) {
      this.customerId = customerId;
    }

    public String getPan() {
      return pan;
    }

    public void setPan(String pan) {
      this.pan = pan;
    }

    public String getAadhar() {
      return aadhar;
    }

    public void setAadhar(String aadhar) {
      this.aadhar = aadhar;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getEmail() {
      return email;
    }

    public void setEmail(String email) {
      this.email = email;
    }

    public String getPhone() {
      return phone;
    }

    public void setPhone(String phone) {
      this.phone = phone;
    }

    public String getDob() {
      return dob;
    }

    public void setDob(String dob) {
      this.dob = dob;
    }

    public String getAddress() {
      return address;
    }

    public void setAddress(String address) {
      this.address = address;
    }



}