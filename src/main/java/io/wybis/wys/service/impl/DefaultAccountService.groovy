package io.wybis.wys.service.impl

import groovy.util.logging.Slf4j
import io.wybis.wys.constants.AccountStatus
import io.wybis.wys.constants.ProductType
import io.wybis.wys.constants.UserType
import io.wybis.wys.model.Account
import io.wybis.wys.model.Product
import io.wybis.wys.model.Stock
import io.wybis.wys.model.User
import io.wybis.wys.repository.AccountRepository
import io.wybis.wys.repository.ProductRepository
import io.wybis.wys.repository.StockRepository
import io.wybis.wys.repository.UserRepository
import io.wybis.wys.service.AccountService
import io.wybis.wys.service.exceptions.ModelAlreadyExistException

import javax.annotation.Resource

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Slf4j
public class DefaultAccountService extends AbstractService implements AccountService {

	@Resource
	StockRepository stockRepository;

	@Resource
	AccountRepository accountRepository;

	@Resource
	UserRepository userRepository;

	@Resource
	ProductRepository productRepository;

	@Transactional
	@Override
	public void add(User sessionUser, Account model)
	throws ModelAlreadyExistException {

		model.status = AccountStatus.ACTIVE
		model.id = this.autoNumberService.nextNumber(sessionUser, model.ID_KEY)

		Account m = this.accountRepository.save(model);
		model.createTime = m.createTime
		model.updateTime = m.updateTime

		if(model.stock) {
			Stock stock = model.stock
			stock.with {
				userId = model.userId
				branchId = model.branchId
			}
			stock.id = this.autoNumberService.nextNumber(sessionUser, Stock.ID_KEY)
			Stock s = this.stockRepository.save(stock)
			stock.createTime = s.createTime
			stock.updateTime = s.updateTime
		}
	}

	@Override
	public void onProductCreate(User sessionUser, Product product) {
		List<User> users = this.userRepository.findByTypeAndBranchId(UserType.EMPLOYEE, product.branchId);

		users.each { user ->
			Stock stock = new Stock();
			stock.with { productId = product.id }
			Account account = new Account()
			account.with {
				type = product.type
				stock = stock
				userId = user.id
				branchId = product.branchId
			}
			this.add(sessionUser, account)
		}
	}

	@Override
	public void onEmployeeCreate(User sessionUser, User employee) {
		List<Product> products = this.productRepository.findByTypeAndBranchId(ProductType.CASH_EMPLOYEE, employee.branchId);

		products.each { product ->
			Stock stock = new Stock();
			stock.with { productId = product.id }
			Account account = new Account()
			account.stock = stock;
			account.with {
				type = product.type
				userId = employee.id
				branchId = employee.branchId
			}
			this.add(sessionUser, account)

			employee.cashAccount = account;
			employee.cashAccountId = account.id
			this.userRepository.save(employee)
		}

		//		products = this.productRepository.findByTypeAndBranchId(ProductType.PROFIT_EMPLOYEE, employee.branchId);
		//
		//		products.each { product ->
		//			Stock stock = new Stock();
		//			stock.with { productId = product.id }
		//			Account account = new Account()
		//			account.stock = stock;
		//			account.with {
		//				type = product.type
		//				userId = employee.id
		//				branchId = employee.branchId
		//			}
		//			this.add(sessionUser, account)
		//
		//			employee.profitAccount = account;
		//			employee.profitAccountId = account.id
		//			this.userRepository.save(employee)
		//		}

		products = this.productRepository.findByTypeAndBranchId(ProductType.PRODUCT, employee.branchId);

		products.each { product ->
			Stock stock = new Stock();
			stock.with { productId = product.id }
			Account account = new Account()
			account.stock = stock;
			account.with {
				type = product.type
				userId = employee.id
				branchId = employee.branchId
			}
			this.add(sessionUser, account)
		}
	}

	@Override
	public void onDealerCreate(User sessionUser, User dealer) {
		List<Product> products = this.productRepository.findByTypeAndBranchId(ProductType.CASH_DEALER, dealer.branchId);

		products.each { product ->
			Account account = new Account()
			account.with {
				isMinus = true
				type = product.type
				userId = dealer.id
				branchId = dealer.branchId
			}
			this.add(sessionUser, account)

			dealer.cashAccountId = account.id
			this.userRepository.save(dealer)
		}
	}

	@Override
	public void onCustomerCreate(User sessionUser, User customer) {
		List<Product> products = this.productRepository.findByTypeAndBranchId(ProductType.CASH_CUSTOMER, customer.branchId);

		products.each { product ->
			Account account = new Account()
			account.with {
				isMinus = true
				type = product.type
				userId = customer.id
				branchId = customer.branchId
			}
			this.add(sessionUser, account)

			customer.cashAccountId = account.id
			this.userRepository.save(customer)
		}
	}
}
