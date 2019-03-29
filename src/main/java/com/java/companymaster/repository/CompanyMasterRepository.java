package com.java.companymaster.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.java.companymaster.model.CompanyMaster;


public interface CompanyMasterRepository extends JpaRepository<CompanyMaster, Integer>{
	
	//final String FIND_PROJECTS = "SELECT mf11_compName FROM CompanyMaster";
	@Query("SELECT mf11_compName FROM CompanyMaster")
	public List<CompanyMaster> findCompanyList();
	
	@Query("SELECT mf11_deactivatedOn FROM CompanyMaster cust where cust.id= ?#{[0]}")
	public String findById(Integer id);
	

}

