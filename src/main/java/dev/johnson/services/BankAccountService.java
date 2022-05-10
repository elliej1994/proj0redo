package dev.johnson.services;

import dev.johnson.entities.BankAccount;

import java.util.List;

public interface BankAccountService {
    BankAccount registerAccount(BankAccount bankAccount);
    List<BankAccount> retrieveAccounts();
    BankAccount getAccountByNo(int recordNo);

     BankAccount makeDeposit(BankAccount bankAccount, double valToDeposit);

     BankAccount makeWithdrawal(BankAccount bankAccount, double valToWithdraw);




}
