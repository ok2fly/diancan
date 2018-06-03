package com.gcfd.model;

public class Branch {
	private Long id;
	private String branch_id;
	private String branch_name;
	private String branch_short_name;
	private String branch_addr;
	/**
	 * 组织统一社会信用代码
	 */
	private String branch_no;
	
	/**
	 * 联系人
	 */
	private String branch_contacts;
	
	private String branch_contacts_phone;
	
	/**
	 */
	private String memo;
	
	private String branch_pic;
	
	
	private String branch_desc;
	
	/**
	 * 是否删除 T是 F否
	 */
	private String is_del;
	
	
	private User user;
	
	private DataSource dataSource;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(String branch_id) {
		this.branch_id = branch_id;
	}

	public String getBranch_name() {
		return branch_name;
	}

	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}

	public String getBranch_short_name() {
		return branch_short_name;
	}

	public void setBranch_short_name(String branch_short_name) {
		this.branch_short_name = branch_short_name;
	}

	public String getBranch_addr() {
		return branch_addr;
	}

	public void setBranch_addr(String branch_addr) {
		this.branch_addr = branch_addr;
	}

	public String getBranch_no() {
		return branch_no;
	}

	public void setBranch_no(String branch_no) {
		this.branch_no = branch_no;
	}

	public String getBranch_contacts() {
		return branch_contacts;
	}

	public void setBranch_contacts(String branch_contacts) {
		this.branch_contacts = branch_contacts;
	}

	public String getBranch_contacts_phone() {
		return branch_contacts_phone;
	}

	public void setBranch_contacts_phone(String branch_contacts_phone) {
		this.branch_contacts_phone = branch_contacts_phone;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getBranch_pic() {
		return branch_pic;
	}

	public void setBranch_pic(String branch_pic) {
		this.branch_pic = branch_pic;
	}

	public String getBranch_desc() {
		return branch_desc;
	}

	public void setBranch_desc(String branch_desc) {
		this.branch_desc = branch_desc;
	}

	public String getIs_del() {
		return is_del;
	}

	public void setIs_del(String is_del) {
		this.is_del = is_del;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((branch_addr == null) ? 0 : branch_addr.hashCode());
		result = prime * result + ((branch_contacts == null) ? 0 : branch_contacts.hashCode());
		result = prime * result + ((branch_contacts_phone == null) ? 0 : branch_contacts_phone.hashCode());
		result = prime * result + ((branch_desc == null) ? 0 : branch_desc.hashCode());
		result = prime * result + ((branch_id == null) ? 0 : branch_id.hashCode());
		result = prime * result + ((branch_name == null) ? 0 : branch_name.hashCode());
		result = prime * result + ((branch_no == null) ? 0 : branch_no.hashCode());
		result = prime * result + ((branch_pic == null) ? 0 : branch_pic.hashCode());
		result = prime * result + ((branch_short_name == null) ? 0 : branch_short_name.hashCode());
		result = prime * result + ((dataSource == null) ? 0 : dataSource.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((is_del == null) ? 0 : is_del.hashCode());
		result = prime * result + ((memo == null) ? 0 : memo.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Branch other = (Branch) obj;
		if (branch_addr == null) {
			if (other.branch_addr != null)
				return false;
		} else if (!branch_addr.equals(other.branch_addr))
			return false;
		if (branch_contacts == null) {
			if (other.branch_contacts != null)
				return false;
		} else if (!branch_contacts.equals(other.branch_contacts))
			return false;
		if (branch_contacts_phone == null) {
			if (other.branch_contacts_phone != null)
				return false;
		} else if (!branch_contacts_phone.equals(other.branch_contacts_phone))
			return false;
		if (branch_desc == null) {
			if (other.branch_desc != null)
				return false;
		} else if (!branch_desc.equals(other.branch_desc))
			return false;
		if (branch_id == null) {
			if (other.branch_id != null)
				return false;
		} else if (!branch_id.equals(other.branch_id))
			return false;
		if (branch_name == null) {
			if (other.branch_name != null)
				return false;
		} else if (!branch_name.equals(other.branch_name))
			return false;
		if (branch_no == null) {
			if (other.branch_no != null)
				return false;
		} else if (!branch_no.equals(other.branch_no))
			return false;
		if (branch_pic == null) {
			if (other.branch_pic != null)
				return false;
		} else if (!branch_pic.equals(other.branch_pic))
			return false;
		if (branch_short_name == null) {
			if (other.branch_short_name != null)
				return false;
		} else if (!branch_short_name.equals(other.branch_short_name))
			return false;
		if (dataSource == null) {
			if (other.dataSource != null)
				return false;
		} else if (!dataSource.equals(other.dataSource))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (is_del == null) {
			if (other.is_del != null)
				return false;
		} else if (!is_del.equals(other.is_del))
			return false;
		if (memo == null) {
			if (other.memo != null)
				return false;
		} else if (!memo.equals(other.memo))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	public Branch(Long id, String branch_id, String branch_name, String branch_short_name, String branch_addr,
			String branch_no, String branch_contacts, String branch_contacts_phone, String memo, String branch_pic,
			String branch_desc, String is_del, User user, DataSource dataSource) {
		super();
		this.id = id;
		this.branch_id = branch_id;
		this.branch_name = branch_name;
		this.branch_short_name = branch_short_name;
		this.branch_addr = branch_addr;
		this.branch_no = branch_no;
		this.branch_contacts = branch_contacts;
		this.branch_contacts_phone = branch_contacts_phone;
		this.memo = memo;
		this.branch_pic = branch_pic;
		this.branch_desc = branch_desc;
		this.is_del = is_del;
		this.user = user;
		this.dataSource = dataSource;
	}

	public Branch() {
		super();
	}
	
	
	
	
}
