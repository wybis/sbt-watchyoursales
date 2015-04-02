package io.wybis.wys.repository;

import io.wybis.wys.model.AutoNumber;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoNumberRepository extends JpaRepository<AutoNumber, String> {

}
