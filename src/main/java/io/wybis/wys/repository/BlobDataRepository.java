package io.wybis.wys.repository;

import io.wybis.wys.model.BlobData;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface BlobDataRepository extends
		PagingAndSortingRepository<BlobData, Long> {

}
