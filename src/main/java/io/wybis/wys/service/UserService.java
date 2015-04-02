package io.wybis.wys.service;

import io.wybis.wys.model.User;
import io.wybis.wys.service.exceptions.ModelAlreadyExistException;

public interface UserService {

	void add(User sessionUser, User model) throws ModelAlreadyExistException;
}
