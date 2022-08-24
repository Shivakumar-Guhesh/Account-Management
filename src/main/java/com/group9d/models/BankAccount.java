package com.group9d.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
// @Table(name = "bankaccount")
public class BankAccount {

    @Column(name = "accountno", columnDefinition = "String")
    String accountNo;

    @Column(name = "Balance", columnDefinition = "int")
    int balance;

    @ManyToOne
    @JoinColumn(name = "CustomerID", referencedColumnName = "CustomerID")
    int customerId;

    BankAccount() {
    }
    public BankAccount(String accountNo, int balance, int customerId) {
      this.accountNo = accountNo;
      this.balance = balance;
      this.customerId = customerId;
    }

    @Id
    public String getAccountNo() {
      return accountNo;
    }
    public void setAccountNo(String accountno) {
      this.accountNo = accountno;
    }

    public int getBalance() {
      return balance;
    }
    public void setBalance(int balance) {
      this.balance = balance;
    }


    public int getCustomerId() {
      return customerId;
    }
    public void setCustomerId(int customerId) {
      this.customerId = customerId;
    }



}
