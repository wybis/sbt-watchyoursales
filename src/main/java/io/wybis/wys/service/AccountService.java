package io.wybis.wys.service;

import io.wybis.wys.model.Account;
import io.wybis.wys.model.Product;
import io.wybis.wys.model.User;
import io.wybis.wys.service.exceptions.ModelAlreadyExistException;

public interface AccountService {

	void add(User sessionUser, Account model) throws ModelAlreadyExistException;

	void onProductCreate(User sessionUser, Product product);

	void onEmployeeCreate(User sessionUser, User employee);

	void onDealerCreate(User sessionUser, User dealer);

	void onCustomerCreate(User sessionUser, User customer);
}
