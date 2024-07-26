package src.application.model.entities;

import src.application.model.exceptions.DomainException;

public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }


    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(Double amount){
       this.balance += amount;
    }

    public void withdraw(Double amount){
        if (amount > withdrawLimit){
           throw new DomainException("Withdraw error: The amount exceeds " +
                   "withdraw limit");
        }
        if (amount > balance){
            throw new DomainException("Withdraw error: Not enough balance.");
        }
        this.balance -= amount;
    }

    
}
