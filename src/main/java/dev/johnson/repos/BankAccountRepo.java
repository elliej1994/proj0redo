package dev.johnson.repos;

import dev.johnson.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository //stereotype of what the component does
//repo component meant for CRUD operations
public interface BankAccountRepo extends JpaRepository<BankAccount,Integer> {


    //uses reflection to create implementations of custom methods

    List<BankAccount> findAccountByUserName(String username);
    List<BankAccount> findAccountByMobileNo(String mobileNo);

}
