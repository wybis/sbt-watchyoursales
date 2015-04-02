package io.wybis.wys.service;

import io.wybis.wys.model.Branch;
import io.wybis.wys.model.User;
import io.wybis.wys.service.exceptions.ModelAlreadyExistException;

public interface EmployeeService {

	void add(User sessionUser, User model) throws ModelAlreadyExistException;

	void onBranchCreate(User sessionUser, Branch branch);
}
