package io.wybis.wys.service.impl;

import io.wybis.wys.service.ConsoleService;

import javax.servlet.http.HttpSession;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DefaultConsoleService extends AbstractService implements
		ConsoleService {

	@Override
	public void reset(HttpSession session) {

	}

	@Override
	public void clear(HttpSession session) {

	}

	@Override
	public void clearTransactions(HttpSession session) {

	}

}
