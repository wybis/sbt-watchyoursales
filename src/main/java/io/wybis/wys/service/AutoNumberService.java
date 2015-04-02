package io.wybis.wys.service;

import io.wybis.wys.model.User;

public interface AutoNumberService {

	long nextNumber(User sessionUser, String key);

}
