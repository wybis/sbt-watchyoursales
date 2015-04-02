package io.wybis.wys.service.impl;

import io.wybis.wys.model.AutoNumber;
import io.wybis.wys.model.User;
import io.wybis.wys.repository.AutoNumberRepository;
import io.wybis.wys.service.AutoNumberService;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class DefaultAutoNumberService implements AutoNumberService {

	@Resource
	AutoNumberRepository autoNumberRepository;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public synchronized long nextNumber(User sessionUser, String key) {
		AutoNumber an = null;

		an = this.autoNumberRepository.findOne(key);
		if (an == null) {
			an = new AutoNumber();
			an.setId(key);
			an.setCreateBy(sessionUser.getId());
			// an.prePersist();
		} else {
			// an.preUpdate();
		}
		an.setUpdateBy(sessionUser.getId());

		an.setValue(an.getValue() + 1);
		an = this.autoNumberRepository.save(an);
		return an.getValue();
	}

}
