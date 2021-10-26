package com.test.www.deribit.repository;

import com.test.www.deribit.domain.accountSummary.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Integer> {
}
