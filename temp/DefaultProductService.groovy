package io.wybis.wys.service.impl

import io.wybis.wys.constants.ProductStatus
import io.wybis.wys.constants.ProductType
import io.wybis.wys.model.Branch
import io.wybis.wys.model.Product
import io.wybis.wys.model.User
import io.wybis.wys.service.ProductService
import io.wybis.wys.service.exceptions.ModelAlreadyExistException
import lombok.extern.slf4j.Slf4j

import org.springframework.stereotype.Service

@Service
@Slf4j
public class DefaultProductService extends AbstractService implements ProductService {

	//StockService stockService

	@Override
	public void add(User sessionUser, Product model)
	throws ModelAlreadyExistException {

		if(model.type == null) {
			model.type = ProductType.PRODUCT
		}
		model.status = ProductStatus.ACTIVE

		model.id = autoNumberService.getNextNumber(sessionUser, Product.ID_KEY)

		model.prePersist(sessionUser.id)
		model.save()

		//stockService.onProductCreate(sessionUser, model)
	}

	@Override
	public void onBranchCreate(User sessionUser, Branch branch) {
		Product model = new Product()

		model.with {
			type = ProductType.CASH_EMPLOYEE
			code = 'CIE'
			name = 'CASH IN EMPLOYEE'
			baseUnit = 1
			denominator = 1
			buyRate = 1
			buyPercent = 1
			sellRate = 1
			sellPercent = 1
			agencyId = agency.id
		}
		this.add(sessionUser, model)

		model.with {
			type = ProductType.PROFIT_EMPLOYEE
			code = 'PIE'
			name = 'PROFIT IN EMPLOYEE'
			baseUnit = 1
			denominator = 1
			buyRate = 1
			buyPercent = 1
			sellRate = 1
			sellPercent = 1
			agencyId = agency.id
		}
		this.add(sessionUser, model)

		model.with {
			type = ProductType.CASH_DEALER
			code = 'CID'
			name = 'CASH IN DEALER'
			baseUnit = 1
			denominator = 1
			buyRate = 1
			buyPercent = 1
			sellRate = 1
			sellPercent = 1
			agencyId = agency.id
		}
		this.add(sessionUser, model)

		model.with {
			type = ProductType.CASH_CUSTOMER
			code = 'CIC'
			name = 'CASH IN CUSTOMER'
			baseUnit = 1
			denominator = 1
			buyRate = 1
			buyPercent = 1
			sellRate = 1
			sellPercent = 1
			agencyId = agency.id
		}
		this.add(sessionUser, model)
	}
}
