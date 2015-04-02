package io.wybis.wys.repository;

import io.wybis.wys.model.Address;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface AddressRepository extends
		PagingAndSortingRepository<Address, Long> {

}
