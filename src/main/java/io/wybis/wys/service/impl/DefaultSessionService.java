package io.wybis.wys.service.impl;

import io.wybis.wys.dto.UserDto;
import io.wybis.wys.service.SessionService;
import io.wybis.wys.service.exceptions.InvalidCredentialException;

import java.util.Map;

import javax.servlet.http.HttpSession;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;

@Service
@Slf4j
public class DefaultSessionService extends AbstractService implements
		SessionService {

	@Override
	public Map<String, Object> properties(HttpSession session) {
		Map<String, Object> props = Maps.newHashMap();

		props.put("user", session.getAttribute("user"));

		return props;
	}

	@Transactional(readOnly = true)
	@Override
	public void login(HttpSession session, UserDto userDto)
			throws InvalidCredentialException {

		String userId = Strings.nullToEmpty(userDto.getUserId());
		if (!userId.equals("vteial@watchyoursales")) {
			throw new InvalidCredentialException();
		}
		session.setAttribute(SESSION_USER_KEY, userDto);
	}

	@Override
	public void logout(HttpSession session) {

		session.removeAttribute(SESSION_USER_KEY);

	}
}
