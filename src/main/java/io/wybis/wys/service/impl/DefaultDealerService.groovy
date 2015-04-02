package io.wybis.wys.service.impl

import groovy.util.logging.Slf4j
import io.wybis.wys.constants.UserType
import io.wybis.wys.model.Branch
import io.wybis.wys.model.Role
import io.wybis.wys.model.User
import io.wybis.wys.repository.BranchRepository
import io.wybis.wys.service.AccountService
import io.wybis.wys.service.DealerService
import io.wybis.wys.service.exceptions.ModelAlreadyExistException

import javax.annotation.Resource

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Slf4j
public class DefaultDealerService extends DefaultUserService implements DealerService {

	@Resource
	BranchRepository branchRepository

	@Resource
	AccountService accountService

	@Transactional
	@Override
	public void add(User sessionUser, User model)
	throws ModelAlreadyExistException {

		if(!model.userId) {
			Branch branch = this.branchRepository.findOne(model.branchId)
			model.userId = "${model.firstName}-${model.lastName}@${branch.name}"
			model.userId = model.userId.toLowerCase()
		}

		model.roleId = Role.ID_DEALER
		model.type = UserType.DEALER

		super.add(sessionUser, model)

		this.accountService.onDealerCreate(sessionUser, model)
	}

	@Override
	public void onBranchCreate(User sessionUser, Branch branch) {

		User model = new User()
		model.with {
			userId = "guest-dealer@$branch.name"
			firstName = 'Guest'
			lastName = 'Dealer'
			branchId = branch.id
		}

		this.add(sessionUser, model)
	}
}
