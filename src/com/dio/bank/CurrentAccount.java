package com.dio.bank;

public class CurrentAccount extends Account{

    private static int SEQUENTIAL = 3351;

    public CurrentAccount(Client client) {
        super(client);
        super.agency = Account.STANDARD_AGENGY;
        super.number = SEQUENTIAL++;
    }

    @Override
    public void printExtract() {
        System.out.println(" === Extrato Conta Corrente === ");
        printAccountInfo();

    }
}
