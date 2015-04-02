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
@Table(name = "orders")
@Data
public class Order extends AbstractModel {

	private static final long serialVersionUID = 1L;

	public static final String ID_KEY = "orderId";

	@Id
	@Column(name = "id")
	private long id;

	@Column(name = "receipt_id")
	private long receiptId;

	private transient OrderReceipt orderReceipt;

	@Column(name = "category")
	private String category;

	@Column(name = "product_code")
	private String productCode;

	@Column(name = "account_id")
	private long accountId;

	private transient Account account;

	@Column(name = "type")
	private String type;

	@Column(name = "base_unit")
	private long baseUnit;

	@Column(name = "unit")
	private double unit;

	@Column(name = "rate")
	private double rate;

	@Column(name = "amount")
	private double amount;

	@Column(name = "date")
	private Date date;

	@Column(name = "status")
	private String status;

	@Column(name = "customer_id")
	private long userId;

	private transient User customer;

	@Column(name = "employee_id")
	private long employeeId;

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
		double value = (this.rate / this.baseUnit);
		value = this.unit * value;
		this.amount = value;
	}
}
