package io.wybis.wys.service;

import io.wybis.wys.model.Branch;
import io.wybis.wys.model.User;
import io.wybis.wys.service.exceptions.ModelAlreadyExistException;

public interface BranchService {

	void add(User sessionUser, Branch model) throws ModelAlreadyExistException;
}
