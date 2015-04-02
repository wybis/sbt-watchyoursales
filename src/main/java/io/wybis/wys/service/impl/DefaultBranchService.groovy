package io.wybis.wys.service.impl;

import groovy.util.logging.Slf4j
import io.wybis.wys.model.Branch
import io.wybis.wys.model.User
import io.wybis.wys.repository.BranchRepository
import io.wybis.wys.service.BranchService
import io.wybis.wys.service.CustomerService
import io.wybis.wys.service.DealerService
import io.wybis.wys.service.EmployeeService
import io.wybis.wys.service.ProductService
import io.wybis.wys.service.exceptions.ModelAlreadyExistException

import javax.annotation.Resource

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class DefaultBranchService extends AbstractService implements
BranchService {

	@Resource
	BranchRepository branchRepository

	@Resource
	ProductService productService

	@Resource
	EmployeeService employeeService

	@Resource
	DealerService dealerService

	@Resource
	CustomerService customerService

	@Transactional
	@Override
	public void add(User sessionUser, Branch model)
	throws ModelAlreadyExistException {

		model.id = this.autoNumberService.nextNumber(sessionUser,
				Branch.ID_KEY)

		Branch m = this.branchRepository.save(model)
		model.createTime = m.createTime
		model.updateTime = m.updateTime

		this.productService.onBranchCreate(sessionUser, model)
		this.employeeService.onBranchCreate(sessionUser, model)
		this.dealerService.onBranchCreate(sessionUser, model)
		this.customerService.onBranchCreate(sessionUser, model)
	}
}
