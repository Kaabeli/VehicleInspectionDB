package vehins.database.VehicleInspectionDB.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Customers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String cusName;
	private String vehModel;
	private String licenceNum;
	private Date insDate;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "inspid")
	private Inspection inspection;
	
	public Customers(String cusName, String vehModel, String licenceNum, Date insDate) {
		
		super();
		this.cusName = cusName;
		this.vehModel = vehModel;
		this.licenceNum = licenceNum;
		this.insDate = insDate;
		
	}
	
	public Customers() {
		super();
	}
	
	
	// Jälleen ketteriä settereitä ^^
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getVehModel() {
		return vehModel;
	}

	public void setVehModel(String vehModel) {
		this.vehModel = vehModel;
	}

	public String getLicenceNum() {
		return licenceNum;
	}

	public void setLicenceNum(String licenceNum) {
		this.licenceNum = licenceNum;
	}

	public Date getInsDate() {
		return insDate;
	}

	public void setInsDate(Date insDate) {
		this.insDate = insDate;
	}

	public Inspection getInspection() {
		return inspection;
	}

	public void setInspection(Inspection inspection) {
		this.inspection = inspection;
	}
	
	public String toString() {
		if (this.inspection != null)
			return "Customers [cusName=" + cusName + ", vehModel=" + vehModel + ", licenceNum=" + licenceNum + ", insDate="
					+ insDate + ", inspection=" + this.getInspection() + "]";
		else
			return "Customers [cusName=" + cusName + ", vehModel=" + vehModel + ", licenceNum=" + licenceNum + ", insDate="
					+ insDate +  "]";
	}
}
