package org.academiadecodigo.tailormoons.BankAccount2;

public class Bank {


    private double accountBalance;
    private int numAccounts;


public Bank() {

}


    public double takeFromAccountBalance(double amount) {
          return accountBalance -= amount;

    }

    public double addToAccountBalance(double amount) {
        return accountBalance += amount;

    }

    public boolean isWithdrawalValid(double withdrawalAmount) {
        if (withdrawalAmount < 0) {

            System.out.println ("Error: amount is invalid.");
            return false;
        }

            if(accountBalance < withdrawalAmount) {
                System.out.println("Not enough money in your bank account to withdraw that amount.");
                return false;


        }
        return true;

    }

    public double getAccountBalance() {
        return accountBalance;

    }
}
