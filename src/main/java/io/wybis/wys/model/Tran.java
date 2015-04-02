package io.wybis.wys.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tran")
@Data
public class Tran {

	private static final long serialVersionUID = 1L;

	public static final String ID_KEY = "tranId";

	@Id
	@Column(name = "id")
	private long id;

	@Column(name = "receipt_id")
	private long receiptId;

	private transient TranReceipt tranReceipt;

	@Column(name = "category")
	private String category;

	@Column(name = "product_code")
	private String productCode;

	@Column(name = "account_id")
	private long accountId;

	private transient Account account;

	@Column(name = "type")
	private String type;

	private transient long baseUnit;

	@Column(name = "unit")
	private long unit;

	private transient double balanceUnit;

	@Column(name = "rate")
	private double rate;

	private transient double averageRate;

	@Column(name = "amount")
	private double amount;

	private transient double balanceAmount;

	@Column(name = "date")
	private Date date;

	@Column(name = "status")
	private String status;

	@Column(name = "order_id")
	private long orderId;

	private transient Order order;

	@Column(name = "customer_id")
	private long customerId;

	private transient User customer;

	@Column(name = "employee_id")
	long employeeId;

	private transient User employee;

	@Column(name = "branch_id")
	private long branchId;

	private transient Branch branch;

	// common fields
	@Column(name = "create_time")
	protected Date createTime;

	@Column(name = "update_time")
	protected Date updateTime;

	@Column(name = "create_by")
	protected long createBy;

	@Column(name = "update_by")
	protected long updateBy;

	// persistence operations

	@PreUpdate
	public void preUpdate() {
		this.updateTime = new Date();
	}

	@PrePersist
	public void prePersist() {
		Date now = new Date();
		this.createTime = now;
		this.updateTime = now;
	}

	// domain operations

	public void computeAmount() {
		if (this.rate == this.balanceUnit) {
			this.amount = this.unit;
		} else {
			double value = (this.rate / this.baseUnit);
			value = this.unit * value;
			this.amount = value;
		}
	}
}
