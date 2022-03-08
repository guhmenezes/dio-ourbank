package com.dio.bank;

public class SavingAccount extends Account{

    private static int SEQUENTIAL = 5501;


    public SavingAccount(Client client) {
        super(client);
        super.agency = Account.STANDARD_AGENGY;
        super.number = SEQUENTIAL++;

    }

    public void toUpdateBalance(){
        // 6 meses na poupança
        this.balance += balance * (super.savingAccountMonthFee * 6);
    }


    @Override
    public void printExtract() {
        System.out.println(" === Extrato Conta Poupança === ");
        toUpdateBalance();
        printAccountInfo();

    }

}
