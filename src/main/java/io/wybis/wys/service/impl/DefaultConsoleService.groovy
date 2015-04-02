package io.wybis.wys.service.impl;

import groovy.util.logging.Slf4j
import io.wybis.wys.model.Branch
import io.wybis.wys.model.User
import io.wybis.wys.service.BranchService
import io.wybis.wys.service.ConsoleService
import io.wybis.wys.service.CustomerService
import io.wybis.wys.service.DealerService
import io.wybis.wys.service.EmployeeService
import io.wybis.wys.service.ProductService

import javax.annotation.Resource
import javax.servlet.http.HttpSession

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Slf4j
public class DefaultConsoleService extends AbstractService implements
ConsoleService {

	@Resource
	BranchService branchService

	@Resource
	ProductService productService

	@Resource
	EmployeeService employeeService

	@Resource
	DealerService dealerService

	@Resource
	CustomerService customerService

	@Override
	public void reset(HttpSession session) {
	}

	@Override
	public void clear(HttpSession session) {
	}

	@Override
	public void clearTransactions(HttpSession session) {
	}

	@Transactional
	@Override
	public void addBranch(HttpSession session, Branch branch) throws Exception {
		log.info("adding branch started...")

		User sessionUser = new User()

		this.branchService.add(sessionUser, branch)

		branch.products.each { t ->
			t.branchId = branch.id
			productService.add(sessionUser, t)
		}

		branch.employees.each { t ->
			t.branchId = branch.id
			this.employeeService.add(sessionUser, t)
		}

		branch.dealers.each { t ->
			t.branchId = branch.id
			this.dealerService.add(sessionUser, t)
		}

		branch.customers.each { t ->
			t.branchId = branch.id
			this.customerService.add(sessionUser, t)
		}

		log.info("adding branch finished...")
	}
}
