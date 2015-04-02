package io.wybis.wys.repository;

import io.wybis.wys.model.Order;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderRepository extends
		PagingAndSortingRepository<Order, Long> {

}
