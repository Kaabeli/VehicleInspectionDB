package vehins.database.VehicleInspectionDB.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Inspection {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long inspid;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "inspection")
	private List<Customers> customers;
	
	public Inspection() {
		
	}
	
	public Inspection(String name) {
		super();
		this.name = name;
	}

	public Long getInspid() {
		return inspid;
	}

	public void setInspid(Long inspid) {
		this.inspid = inspid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public List<Customers> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customers> customers) {
		this.customers = customers;
	}
	
	@Override
	public String toString() {
		return "Inspection [inspid=" + inspid + ", name=" + name + "]";
	}

}
