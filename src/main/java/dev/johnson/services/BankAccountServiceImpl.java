package dev.johnson.services;

import dev.johnson.entities.BankAccount;
import dev.johnson.repos.BankAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
@Service
public class BankAccountServiceImpl implements BankAccountService{


    @Autowired
    private BankAccountRepo bankAccountRepo;



    @Override
    public BankAccount registerAccount(BankAccount bankAccount) {
        //optional set for various defaults
        return this.bankAccountRepo.save(bankAccount);
    }

    @Override
    public List<BankAccount> retrieveAccounts() {
        return this.bankAccountRepo.findAll();
    }

    @Override
    public BankAccount getAccountByNo(int recordNo) {
        Optional<BankAccount> possibleAcc = this.bankAccountRepo.findById(recordNo);
        if(possibleAcc.isPresent()){
            return possibleAcc.get();
        }else{
            throw new RuntimeException("No account with that num");
        }

    }

    @Override
    public BankAccount makeDeposit(BankAccount bankAccount, double valToDeposit) {
        bankAccount.setBalance(bankAccount.getBalance()+valToDeposit);
        return this.bankAccountRepo.save(bankAccount);
    }

    @Override
    public BankAccount makeWithdrawal(BankAccount bankAccount, double valToWithdraw) {
        bankAccount.setBalance(bankAccount.getBalance()-valToWithdraw);
        return this.bankAccountRepo.save(bankAccount);
    }


}
