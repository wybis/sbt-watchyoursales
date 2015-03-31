package io.wybis.wys.service;

import io.wybis.wys.dto.UserDto;
import io.wybis.wys.service.exceptions.InvalidCredentialException;

import java.util.Map;

import javax.servlet.http.HttpSession;

public interface SessionService {

	static String SESSION_USER_KEY = "user";

	Map<String, Object> properties(HttpSession session);
	
	void login(HttpSession session, UserDto user)
			throws InvalidCredentialException;

	void logout(HttpSession session);

}
