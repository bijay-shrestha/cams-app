package edu.miu.camsapp.repository;


import edu.miu.camsapp.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author bijayshrestha on 7/12/22
 * @project cams-app
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
