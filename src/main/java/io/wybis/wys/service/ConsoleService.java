package io.wybis.wys.service;

import io.wybis.wys.model.Branch;

import java.util.List;

import javax.servlet.http.HttpSession;

public interface ConsoleService {

	void reset(HttpSession session);

	void clear(HttpSession session);

	void clearTransactions(HttpSession session);

	void addBranch(HttpSession session, Branch branch) throws Exception;

	List<Branch> branchs(HttpSession session);

}
