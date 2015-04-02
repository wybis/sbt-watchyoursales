package io.wybis.wys.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.Data;

import com.google.common.base.Strings;

@Entity
@Table(name = "accounts")
@Data
public class Account extends AbstractModel {

	private static final long serialVersionUID = 1L;

	public static final String ID_KEY = "accountId";

	@Id
	@Column(name = "id")
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "alias_name")
	private String aliasName;

	@Column(name = "type")
	private String type;

	@Column(name = "is_minus")
	private boolean isMinus;

	@Column(name = "balance")
	private double balance;

	@Column(name = "status")
	private String status;

	@Column(name = "stock_id", nullable = true)
	private long stockId;

	// @OneToOne(mappedBy = "stock")
	private transient Stock stock;

	@Column(name = "user_id")
	private String userId;

	// @OneToOne
	private transient User user;

	@Column(name = "branch_id")
	private long branchId;

	// @OneToOne(mappedBy = "account")
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
	public boolean hasSufficientBalance(double amount) {

		if (this.isMinus()) {
			return true;
		}

		return this.balance >= amount;
	}

	public void withdraw(double amount) {
		this.balance -= amount;
	}

	public void deposit(double amount) {
		this.balance += amount;
	}
}
