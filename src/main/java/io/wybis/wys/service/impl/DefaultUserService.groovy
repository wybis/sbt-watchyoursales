package io.wybis.wys.service.impl

import io.wybis.wys.constants.UserStatus
import io.wybis.wys.model.User
import io.wybis.wys.repository.UserRepository
import io.wybis.wys.service.UserService
import io.wybis.wys.service.exceptions.ModelAlreadyExistException

import javax.annotation.Resource

import lombok.extern.slf4j.Slf4j

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class DefaultUserService extends AbstractService implements UserService {

	@Resource
	private UserRepository userRepository;

	@Transactional
	@Override
	public void add(User sessionUser, User model)
	throws ModelAlreadyExistException {

		//		def entitys = datastore.execute {
		//			from User.class.simpleName
		//			where userId == model.userId
		//		}
		//
		//		if(entitys.size() > 0) {
		//			throw new ModelAlreadyExistException()
		//		}

		model.status = UserStatus.ACTIVE
		model.id = autoNumberService.nextNumber(sessionUser, User.ID_KEY)

		User m = this.userRepository.save(model)
		model.createTime = m.createTime
		model.updateTime = m.updateTime
	}
}
