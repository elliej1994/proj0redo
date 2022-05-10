package dev.johnson.controllers;


import dev.johnson.entities.BankAccount;
import dev.johnson.services.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@Controller //stereotype for spring that says that this class is used to generate a bean that defines api routes for the webserver

public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    @GetMapping("/bankaccounts")
    @ResponseBody//automatically converts return to JSON
    public List<BankAccount> retrieveAccounts(){
        List<BankAccount> bankAccounts = this.bankAccountService.retrieveAccounts();
        return bankAccounts;
    }

    @GetMapping("/bankaccounts/{recordNo}")
    @ResponseBody
    public BankAccount retrieveAccountByRecordNo(@PathVariable int recordNo){
        BankAccount bankAccount = this.bankAccountService.getAccountByNo(recordNo);
        return bankAccount;
    }

    @PostMapping("/bankaccounts")
    @ResponseBody
    public BankAccount postBankAccount(@RequestBody BankAccount bankAccount){
        return this.bankAccountService.registerAccount(bankAccount);
    }



}
