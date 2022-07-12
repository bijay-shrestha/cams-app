package edu.miu.camsapp.repository;


import edu.miu.camsapp.model.Account;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * @author bijayshrestha on 7/12/22
 * @project cams-app
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query(value = "SELECT a FROM Account a ORDER BY a.balance DESC")
    List<Account> findAllAccounts();

    @Query(value = "SELECT a FROM Account a WHERE a.balance > 10000")
    Collection<Account> findPrimeCustomerAccounts();
}
