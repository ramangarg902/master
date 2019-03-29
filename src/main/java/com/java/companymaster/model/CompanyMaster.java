package com.java.companymaster.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MF11_M_COMPMAST")
public class CompanyMaster {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "id")
	    private Integer id;
	    @Column(name = "mf11_compCode")
	    private Integer mf11_compCode;
	    @Column(name = "mf11_compCodeHRIS")
	    private String mf11_compCodeHRIS;
	    @Column(name = "mf11_compName")
	    private String mf11_compName;
	    @Column(name = "mf11_compAbbrName")
	    private String mf11_compAbbrName;
	    @Column(name = "mf11_compRegNo")
	    private String mf11_compRegNo;
	    @Column(name = "mf11_compLogo")
	    private String mf11_compLogo;
	    @Column(name = "Mf11_compActiveString")
	    private String Mf11_compActiveString;
	    @Column(name = "mf11_isActive")
	    private boolean mf11_isActive;
	    @Column(name = "mf11_createdOn")
	    private String mf11_createdOn;
	    @Column(name = "mf11_createdBy")
	    private String mf11_createdBy;
	    @Column(name = "mf11_lastModifiedOn")
	    private String mf11_lastModifiedOn;
	    @Column(name = "mf11_lastModifiedBy")
	    private String mf11_lastModifiedBy;
	    @Column(name = "mf11_deactivatedBy")
	    private String mf11_deactivatedBy;
	    @Column(name = "mf11_deactivatedOn")
	    private String mf11_deactivatedOn;
	    @Column(name = "mf11_reactivatedBy")
	    private String mf11_reactivatedBy; 
	    @Column(name = "mf11_reactivatedOn")
	    private String mf11_reactivatedOn;
	    @Column(name = "mf11_jsonField")
	    private String mf11_jsonField;
	    
	    
	    public CompanyMaster() {
	    	
	    }
	    public CompanyMaster(CompanyMaster companyMaster) {
	    	this.mf11_compCode=companyMaster.getMf11_compCode();
	    	this.mf11_compCodeHRIS=companyMaster.getMf11_compCodeHRIS();
	    	this.mf11_compName=companyMaster.getMf11_compName();
	    	this.mf11_compAbbrName=companyMaster.getMf11_compAbbrName();
	    	this.mf11_compRegNo=companyMaster.getMf11_compRegNo();
	    	this.mf11_compLogo=companyMaster.getMf11_compLogo();
	    	this.Mf11_compActiveString=companyMaster.getMf11_compActiveString();
	    	this.mf11_isActive=companyMaster.isMf11_isActive();
	    	this.mf11_createdOn=companyMaster.getMf11_createdOn();
	    	this.mf11_createdBy=companyMaster.getMf11_createdBy();
	    	this.mf11_lastModifiedOn=companyMaster.getMf11_lastModifiedOn();
	    	this.mf11_lastModifiedBy=companyMaster.getMf11_lastModifiedBy();
	    	this.mf11_deactivatedBy=companyMaster.getMf11_deactivatedBy();
	    	this.mf11_deactivatedOn=companyMaster.getMf11_deactivatedOn();
	    	this.mf11_reactivatedBy=companyMaster.getMf11_reactivatedBy();
	    	this.mf11_reactivatedOn=companyMaster.getMf11_reactivatedOn();
	    	this.mf11_jsonField=companyMaster.getMf11_jsonField();
	    }
	    

		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Integer getMf11_compCode() {
			return mf11_compCode;
		}
		public void setMf11_compCode(Integer mf11_compCode) {
			this.mf11_compCode = mf11_compCode;
		}
		public String getMf11_compCodeHRIS() {
			return mf11_compCodeHRIS;
		}
		public void setMf11_compCodeHRIS(String mf11_compCodeHRIS) {
			this.mf11_compCodeHRIS = mf11_compCodeHRIS;
		}
		public String getMf11_compName() {
			return mf11_compName;
		}
		public void setMf11_compName(String mf11_compName) {
			this.mf11_compName = mf11_compName;
		}
		public String getMf11_compAbbrName() {
			return mf11_compAbbrName;
		}
		public void setMf11_compAbbrName(String mf11_compAbbrName) {
			this.mf11_compAbbrName = mf11_compAbbrName;
		}
		public String getMf11_compRegNo() {
			return mf11_compRegNo;
		}
		public void setMf11_compRegNo(String mf11_compRegNo) {
			this.mf11_compRegNo = mf11_compRegNo;
		}
		public String getMf11_compLogo() {
			return mf11_compLogo;
		}
		public void setMf11_compLogo(String mf11_compLogo) {
			this.mf11_compLogo = mf11_compLogo;
		}
		public String getMf11_compActiveString() {
			return Mf11_compActiveString;
		}
		public void setMf11_compActiveString(String mf11_compActiveString) {
			Mf11_compActiveString = mf11_compActiveString;
		}
		public boolean isMf11_isActive() {
			return mf11_isActive;
		}
		public void setMf11_isActive(boolean mf11_isActive) {
			this.mf11_isActive = mf11_isActive;
		}
		public String getMf11_createdOn() {
			return mf11_createdOn;
		}
		public void setMf11_createdOn(String mf11_createdOn) {
			this.mf11_createdOn = mf11_createdOn;
		}
		public String getMf11_createdBy() {
			return mf11_createdBy;
		}
		public void setMf11_createdBy(String mf11_createdBy) {
			this.mf11_createdBy = mf11_createdBy;
		}
		public String getMf11_lastModifiedOn() {
			return mf11_lastModifiedOn;
		}
		public void setMf11_lastModifiedOn(String mf11_lastModifiedOn) {
			this.mf11_lastModifiedOn = mf11_lastModifiedOn;
		}
		public String getMf11_lastModifiedBy() {
			return mf11_lastModifiedBy;
		}
		public void setMf11_lastModifiedBy(String mf11_lastModifiedBy) {
			this.mf11_lastModifiedBy = mf11_lastModifiedBy;
		}
		public String getMf11_deactivatedBy() {
			return mf11_deactivatedBy;
		}
		public void setMf11_deactivatedBy(String mf11_deactivatedBy) {
			this.mf11_deactivatedBy = mf11_deactivatedBy;
		}
		public String getMf11_deactivatedOn() {
			return mf11_deactivatedOn;
		}
		public void setMf11_deactivatedOn(String mf11_deactivatedOn) {
			this.mf11_deactivatedOn = mf11_deactivatedOn;
		}
		public String getMf11_reactivatedBy() {
			return mf11_reactivatedBy;
		}
		public void setMf11_reactivatedBy(String mf11_reactivatedBy) {
			this.mf11_reactivatedBy = mf11_reactivatedBy;
		}
		public String getMf11_reactivatedOn() {
			return mf11_reactivatedOn;
		}
		public void setMf11_reactivatedOn(String mf11_reactivatedOn) {
			this.mf11_reactivatedOn = mf11_reactivatedOn;
		}
		public String getMf11_jsonField() {
			return mf11_jsonField;
		}
		public void setMf11_jsonField(String mf11_jsonField) {
			this.mf11_jsonField = mf11_jsonField;
		}
	    
	    
}
