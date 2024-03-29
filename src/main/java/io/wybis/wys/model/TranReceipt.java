package io.wybis.wys.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tran_receipt")
@Data
public class TranReceipt {

	private static final long serialVersionUID = 1L;

	public static final String ID_KEY = "tranReceiptId";

	@Id
	@Column(name = "id")
	private long id;

	@Column(name = "category")
	private String category;

	@Column(name = "date")
	private Date date;

	private transient double totalAmount;

	private transient double totalSaleAmount;

	@Column(name = "description")
	private String description;

	@Column(name = "status")
	private String status;

	@Column(name = "customer_id")
	private long customerId;

	private transient User customer;

	@Column(name = "employee_id")
	long employeeId;

	private transient User employee;

	@Column(name = "branch_id")
	long branchId;

	private transient Branch branch;

	private transient List<Tran> trans;

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
}
