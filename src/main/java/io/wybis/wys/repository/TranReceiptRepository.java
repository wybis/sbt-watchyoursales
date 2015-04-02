package io.wybis.wys.repository;

import io.wybis.wys.model.TranReceipt;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface TranReceiptRepository extends
		PagingAndSortingRepository<TranReceipt, Long> {

}
