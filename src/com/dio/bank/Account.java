package com.dio.bank;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Account implements IAccount{

    public static final String DATE_FORMATTER = "dd/MM/yyyy - HH:mm";
    LocalDateTime localDateTime = LocalDateTime.now();
    DateTimeFormatter dtformatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
    String transactionTime =localDateTime.format((dtformatter));

    protected static int STANDARD_AGENGY = 1;
    protected int agency;
    protected int number;
    protected double balance;

    protected double transferFee = 5;
    protected double savingAccountMonthFee = 0.266666667;

    protected Client client;

    public Account(Client client) {
        this.client = client;
    }


    @Override
    public void toWithdraw(double value) {
        boolean haveABalance = (this.balance - value) > 0;
        if(haveABalance) {
            this.balance -= value;
            System.out.println(transactionTime);
            System.out.println("Saque");
            System.out.println(String.format("R$ %.2f D\n", value));
        }
        else System.out.println("Operação não realizada");
    }

    @Override
    public void toDeposit(double value) {
        this.balance += value;
        System.out.println(transactionTime);
        System.out.println("Depósito");
        System.out.println(String.format("R$ %.2f C\n", value));
    }

    @Override
    public void toTransfer(double value, Account destinationAccount) {
        boolean sameClient = client.getCpf().equals(destinationAccount.client.getCpf());
        boolean haveABalance = (this.balance - value) > 0;
        if (sameClient && haveABalance){
            this.balance -= value;
            destinationAccount.balance += value;
            System.out.println(transactionTime);
            System.out.println("Transferência para a mesma titularidade");
            System.out.println(String.format("R$ %.2f D\n", value));
        } else if (haveABalance){
            this.balance -= (value + transferFee);
            destinationAccount.balance += value;
            System.out.println(transactionTime);
            System.out.println("Transferência para outra titularidade");
            System.out.println(String.format("R$ %.2f D\n", value));
            System.out.println(transactionTime);
            System.out.println("Tarifa sobre transferência");
            System.out.println(String.format("R$ %.2f D\n", transferFee));
        } else {
            System.out.println("Operação não autorizada");
        }

    }



    protected void printAccountInfo(){
        System.out.println(String.format("Titular: %s %s", client.getName(), client.getLastName()));
        System.out.println(String.format("Agência: %d", agency));
        System.out.println(String.format("Conta: %d", number));
        System.out.println(String.format("Saldo: %.2f", balance));
    }

    public int getAgency() {
        return agency;
    }

    public int getNumber() {
        return number;
    }

    public double getBalance() {
        return balance;
    }
}
