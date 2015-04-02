package io.wybis.wys.repository;

import io.wybis.wys.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

	List<User> findByTypeAndBranchId(String type, long branchId);

}
