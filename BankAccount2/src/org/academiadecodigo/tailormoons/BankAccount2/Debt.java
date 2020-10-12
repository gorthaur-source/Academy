package org.academiadecodigo.tailormoons.BankAccount2;

public class Debt {

    private double[] debt;
    private String[] name;
    private double[] credit;
    private String[] creditName;
    private static int Index = 0;

    public Debt() {
        debt = new double[20];
        name = new String[20];
        credit = new double[20];
        creditName = new String[10];
    }



    public boolean isCreditValid(double creditAmount) {
        if (creditAmount < 0) {

            System.out.println ("Error: amount is invalid.");
            return false;
        }

        return true;

    }



    public double[] getDebt() {

        return debt;
    }

    public void setDebtAmount (int Index, double amount){
        debt[Index] = amount;

    }

    public void setCreditAmount(int Index, double amount) {
        credit[Index] = amount;
    }

    public void setName (int Index, String name) {
        this.name[Index] = name;
    }

    public void setCreditName(int Index, String name) {
        creditName[Index] = name;
        Index++;
    }

    public String[] getName (int index) {

        return name;
    }

}

