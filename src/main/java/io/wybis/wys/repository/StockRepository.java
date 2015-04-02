package io.wybis.wys.repository;

import io.wybis.wys.model.Stock;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface StockRepository extends
		PagingAndSortingRepository<Stock, Long> {

}
