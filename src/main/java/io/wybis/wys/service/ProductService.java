package io.wybis.wys.service;

import io.wybis.wys.model.Branch;
import io.wybis.wys.model.Product;
import io.wybis.wys.model.User;
import io.wybis.wys.service.exceptions.ModelAlreadyExistException;

public interface ProductService {

	void add(User sessionUser, Product model) throws ModelAlreadyExistException;
	
	void onBranchCreate(User sessionUser, Branch branch);
}
