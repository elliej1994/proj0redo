package dev.johnson.proj0redo;

import dev.johnson.entities.BankAccount;
import dev.johnson.repos.BankAccountRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class BankAccountRepoTests {

    @Autowired
    private BankAccountRepo bankAccountRepo;


    @Test
    public void create_account_test(){
        BankAccount bankAccount = new BankAccount(0,87.95,"Barbara","Jenkins","44-444-4444","username1","pass1234");
        bankAccountRepo.save(bankAccount);
        System.out.println(bankAccount);
        Assertions.assertNotEquals(0,bankAccount.getAccountNo());

    }
    @Test
    public void get_all_accounts(){
        List<BankAccount> bankAccountList = this.bankAccountRepo.findAll();
        System.out.println(bankAccountList);
    }

    @Test
    public void get_acc_by_recordno(){
        //optionals are empty containers
        Optional<BankAccount> possbankAccount = this.bankAccountRepo.findById(5);
        if(possbankAccount.isPresent()){
            BankAccount bankAccount = possbankAccount.get();
            System.out.println(bankAccount);

            }else{
            System.out.println("No account was found");
            }
        }

        @Test
        public void find_by_username(){
        List<BankAccount> usernameSearch = this.bankAccountRepo.findAccountByUserName("jdirty45");
            System.out.println(usernameSearch);
        }

        @Test
        public void findbyphone(){
        List<BankAccount> mobileNoSearch = this.bankAccountRepo.findAccountByMobileNo("555-555-5555");
            System.out.println(mobileNoSearch);
        }


}
