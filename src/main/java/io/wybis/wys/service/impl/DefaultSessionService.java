package io.wybis.wys.service.impl;

import io.wybis.wys.dto.UserDto;
import io.wybis.wys.service.SessionService;
import io.wybis.wys.service.exceptions.InvalidCredentialException;

import javax.servlet.http.HttpSession;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;

@Service
@Slf4j
public class DefaultSessionService extends AbstractService implements
		SessionService {

	@Transactional(readOnly = true)
	@Override
	public void login(HttpSession session, UserDto userDto)
			throws InvalidCredentialException {

		String userId = Strings.nullToEmpty(userDto.getUserId());
		if (!userId.equals("vteial@watchyoursales")) {
			throw new InvalidCredentialException();
		}
		session.setAttribute("user", userDto);
	}

	@Override
	public void logout(HttpSession session) {
		session.removeAttribute("user");
	}
}
