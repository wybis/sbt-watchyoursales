package io.wybis.wys.repository;

import io.wybis.wys.model.Account;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface AccountRepository extends
		PagingAndSortingRepository<Account, Long> {

}
