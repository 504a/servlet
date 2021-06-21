package model;

public class Member {
	private int id;
	private String name;
	private String zip;
	private String address1;
	private String address2;
	private String phone;
	private String remarks;

	public Member() {
	}

	public Member(int id, String name, String zip, String address1, String address2, String phone, String remarks) {
		super();
		this.id = id;
		this.name = name;
		this.zip = zip;
		this.address1 = address1;
		this.address2 = address2;
		this.phone = phone;
		this.remarks = remarks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
