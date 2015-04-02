package io.wybis.wys.repository;

import io.wybis.wys.model.Product;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends
		PagingAndSortingRepository<Product, Long> {

	List<Product> findByTypeAndBranchId(String type, long branchId);
}
