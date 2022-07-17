package crm.infrastructure.Lead;

import crm.domain.Account.Account;
import crm.domain.Account.AccountRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class InMemoryAccountRepository implements AccountRepository {
    private final Map<UUID, Account> accounts;

    public InMemoryAccountRepository() {
        this.accounts = new HashMap<>();
    }

    @Override
    public void save(Account account) {
        this.accounts.put(account.getId(), account);
    }

}
