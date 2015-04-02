package io.wybis.wys.repository;

import io.wybis.wys.model.Tran;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface TranRepository extends
		PagingAndSortingRepository<Tran, Long> {

}
