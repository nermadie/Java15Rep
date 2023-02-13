package bean;

import java.util.Objects;

public class Warehouse {
	private String whId;
	private String address;

	public Warehouse() {
	}

	public Warehouse(String whId, String address) {
		this.whId = whId;
		this.address = address;
	}

	public String getWhId() {
		return whId;
	}

	public void setWhId(String whId) {
		this.whId = whId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Warehouse))
			return false;
		Warehouse that = (Warehouse) obj;
		return getWhId().equals(that.getWhId()) && getAddress().equals(that.getAddress());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getWhId(), getAddress());
	}

	@Override
	public String toString() {
		return "Warehouse [whId=" + whId + ", address=" + address + "]";
	}
}
