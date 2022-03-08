package com.dio.bank;

public interface IAccount {

    void toWithdraw(double value);

    void toDeposit(double value);

    void toTransfer(double value, Account destinationAccount);

    void printExtract();
}
