package solo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import solo.models.Account;
import solo.models.Client;
import solo.repositories.AccountRepository;


import java.util.List;


@Service
@Transactional(readOnly = true)
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> findByEmail(String email) {
        return accountRepository.findByEmail(email);
    }

    public List<Account> findByOwner(Client owner) {
        return accountRepository.findByOwner(owner);
    }

    @Transactional
    public void save(Account account) {
        accountRepository.save(account);
    }


}
