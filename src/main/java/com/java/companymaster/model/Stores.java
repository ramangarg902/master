package com.java.companymaster.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MF11_Store")
public class Stores {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Integer id;
	@Column(name = "mf11_storeCode", unique = true)
	private Integer mf11_storeCode;
	@Column(name = "mf11_storeName")
	private String mf11_storeName;
	@Column(name = "mf11_storeAbbr")
	private String mf11_storeAbbr;
	@Column(name = "mf11_companyName")
	private String mf11_companyName;
	@Column(name = "company_id")
	private Integer companyId;

	@Override
	public String toString() {
		return "Stores [id=" + id + ", mf11_storeCode=" + mf11_storeCode + ", mf11_storeName=" + mf11_storeName
				+ ", mf11_storeAbbr=" + mf11_storeAbbr + ", mf11_companyName=" + mf11_companyName + ", companyId="
				+ companyId + "]";
	}

	public Stores() {

	}

	public Integer getId() {
		return id;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMf11_storeCode() {
		return mf11_storeCode;
	}

	public void setMf11_storeCode(Integer mf11_storeCode) {
		this.mf11_storeCode = mf11_storeCode;
	}

	public String getMf11_storeName() {
		return mf11_storeName;
	}

	public void setMf11_storeName(String mf11_storeName) {
		this.mf11_storeName = mf11_storeName;
	}

	public String getMf11_storeAbbr() {
		return mf11_storeAbbr;
	}

	public void setMf11_storeAbbr(String mf11_storeAbbr) {
		this.mf11_storeAbbr = mf11_storeAbbr;
	}

	public String getMf11_companyName() {
		return mf11_companyName;
	}

	public void setMf11_companyName(String mf11_companyName) {
		this.mf11_companyName = mf11_companyName;
	}

}
