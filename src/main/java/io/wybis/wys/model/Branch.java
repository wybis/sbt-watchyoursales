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
@Table(name = "branch")
@Data
public class Branch extends AbstractModel {

	private static final long serialVersionUID = 1L;

	public static final String ID_KEY = "branchId";

	@Id
	@Column(name = "id")
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "alias_name")
	private String aliasName;

	@Column(name = "licence_number")
	String licenceNumber;

	@Column(name = "email_id")
	private String emailId;

	@Column(name = "hand_phone_no")
	private String handPhoneNumber;

	@Column(name = "land_phone_no")
	private String landPhoneNumber;

	@Column(name = "fax_no")
	private String faxNumber;

	@Column(name = "address_id")
	private long addressId;

	private transient Address address;

	@Column(name = "status")
	private String status;

	@Column(name = "parent_id")
	private long parentId;

	private transient List<Product> products;

	private transient List<User> employees;

	private transient List<User> dealers;

	private transient List<User> customers;

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
