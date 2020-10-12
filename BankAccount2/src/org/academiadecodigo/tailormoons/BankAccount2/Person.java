package org.academiadecodigo.tailormoons.BankAccount2;

public class Person {

    private final String name;
    private final double initialWalletBalance;
    private Wallet personalWallet;
    private Bank bankAccount;
    private Debt debt;

public Person(String name, double initialWallet) {
    this.name = name;
    this.personalWallet = new Wallet();
    this.bankAccount = new Bank();
    this.initialWalletBalance = personalWallet.addToWalletBalance(initialWallet);
    this.debt = new Debt();
}

    public void bankToWallet(double withdrawalAmount) {

        if(bankAccount.isWithdrawalValid(withdrawalAmount)) {
            bankAccount.takeFromAccountBalance(withdrawalAmount);
            personalWallet.addToWalletBalance(withdrawalAmount);
        }
    }

    public void walletToBank(double depositAmount) {

        if(personalWallet.isDepositValid(depositAmount)) {
            personalWallet.takeFromWalletBalance(depositAmount);
            bankAccount.addToAccountBalance(depositAmount);
        }
    }

    public void bankToBank(Bank to, double transferAmount) {

        if(bankAccount.isWithdrawalValid(transferAmount)) {
            bankAccount.takeFromAccountBalance(transferAmount);
            to.addToAccountBalance(transferAmount);
        }
    }

    public void takeFromWallet(double amount) {

        if(amount <0) {
            System.out.println ("Error: amount is invalid.");

        }

        personalWallet.takeFromWalletBalance(amount);
    }

    public void contractDebt(Debt debtor, double lentAmount) {
        if(debt.isCreditValid(lentAmount) && lentAmount>bankAccount.getAccountBalance()) {
            return;
        }
    }






    public double getWalletBalance() {

        return personalWallet.getWalletBalance();
    }

    public double getBankBalance() {

        return bankAccount.getAccountBalance();
    }

    public String getName() {

        return this.name;
    }

    public Bank getBankAccount() {

        return this.bankAccount;
    }

}

