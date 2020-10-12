package org.academiadecodigo.tailormoons.BankAccount2;

public class Main {


    public static void main(String[] args) {
        Person Hugo = new Person("Hugo", 5000);
        Person João = new Person("João", 800);


        Hugo.walletToBank(3000);
        Hugo.bankToBank(João.getBankAccount(), 3000);


        System.out.println(Hugo.getBankBalance());
        System.out.println(Hugo.getWalletBalance());

        /*
        Hugo.bankToWallet(3000);
        System.out.println(Hugo.getBankBalance());
        System.out.println(Hugo.getWalletBalance());


        Hugo.bankToBank(João.getBankAccount(), 1000);

        System.out.println(Hugo.getBankBalance()); // 2000
        System.out.println(João.getBankBalance()); // 1000

        João.walletToBank(900);
        System.out.println(João.getBankBalance());
        System.out.println(João.getWalletBalance());
*/
    }
}
