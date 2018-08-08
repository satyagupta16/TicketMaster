package ticketmaster.shared;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@SuppressWarnings("serial")
public class Person implements Serializable {
	@Id
	@GeneratedValue
	@Column
	private int rowId;

	@Column
	private String name;
	@Column
	private String id;
	@Column
	private String address;
	@Column
	private String phone;
	@Column
	private String type;

	public Person() {
	}

	public int getRowId() {
		return rowId;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public String getType() {
		return type;
	}

	public void setRowId(int rowId) {
		this.rowId = rowId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return name + ", " + id + ", " + address + ", " + phone + ", " + type;
	}
}
