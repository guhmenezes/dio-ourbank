package com.dio.bank;

public class RunApplication {
    public static void main(String[] args) {
        System.out.println("");
        Client client1 = new Client("José", "Silva", "1234");
        Client client2 = new Client("Maria", "Silva", "4321");

        Account ca = new CurrentAccount(client1);
        ca.toDeposit(500);
        Account sa = new SavingAccount(client1);
        Account ca2 = new CurrentAccount(client2);

        ca.toTransfer(200, sa);
        ca.toTransfer(100, ca2);
        ca2.toWithdraw(40);
        ca.printExtract();
        sa.printExtract();
        ca2.printExtract();
    }
}
