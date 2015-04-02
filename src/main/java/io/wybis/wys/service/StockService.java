package io.wybis.wys.service;

import io.wybis.wys.model.Branch;
import io.wybis.wys.model.User;
import io.wybis.wys.service.exceptions.ModelAlreadyExistException;

interface StockService {

	void add(User sessionUser, Branch branch) throws ModelAlreadyExistException;
}
