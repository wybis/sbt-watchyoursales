package io.wybis.wys.model;

import java.util.Arrays;
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
@Table(name = "role")
@Data
public class Role extends AbstractModel {

	private static final long serialVersionUID = 1L;

	public static final String ID_MANAGER = "manager";

	public static final String ID_EMPLOYEE = "employee";

	public static final String ID_CUSTOMER = "customer";

	public static final String ID_DEALER = "dealer";

	public static final List<String> ROLES = Arrays.asList(ID_MANAGER,
			ID_EMPLOYEE, ID_CUSTOMER, ID_DEALER);

	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "name")
	private String name;

	// common fields...
	@Column(name = "create_time")
	protected Date createTime;

	@Column(name = "update_time")
	protected Date updateTime;

	@Column(name = "create_by")
	protected String createBy;

	@Column(name = "update_by")
	protected String updateBy;

	// persistance operations
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
