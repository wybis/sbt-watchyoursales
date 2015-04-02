package io.wybis.wys.repository;

import io.wybis.wys.model.OrderReceipt;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderReceiptRepository extends
		PagingAndSortingRepository<OrderReceipt, Long> {

}
