package io.wybis.wys.service;

import javax.servlet.http.HttpSession;

public interface ConsoleService {

	void reset(HttpSession session);

	void clear(HttpSession session);

	void clearTransactions(HttpSession session);

}
