package solo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import solo.models.Account;
import solo.models.Client;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {

    List<Account> findByOwner(Client owner);

    List<Account> findByEmail(String email);


}
