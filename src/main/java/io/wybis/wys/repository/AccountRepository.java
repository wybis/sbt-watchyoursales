package io.wybis.wys.repository;

import io.wybis.wys.model.Account;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface AccountRepository extends
		PagingAndSortingRepository<Account, Long> {

	List<Account> findByBranchId(long branchId);
	
}
