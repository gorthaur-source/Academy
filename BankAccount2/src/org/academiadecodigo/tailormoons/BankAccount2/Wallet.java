package org.academiadecodigo.tailormoons.BankAccount2;

public class Wallet {

    private double balance = 0;


    public double takeFromWalletBalance(double amount) {
        if (balance < amount) {
            System.out.println("Not enough money in your wallet to withdraw that amount.");
            return -1;
        }

        System.out.println("no sense " + getWalletBalance());
        return balance -= amount;
    }

    public boolean isDepositValid(double depositAmount) {

        if (depositAmount < 0) {
            System.out.println("Error: amount is invalid.");
            return false;
        }

        if (balance < depositAmount) {
            System.out.println("Not enough money in your wallet to withdraw that amount.");
            return false;
        }

        return true;

    }

    public double addToWalletBalance(double amount) {
        return balance += amount;

    }

    public double getWalletBalance() {
        return balance;
    }

}