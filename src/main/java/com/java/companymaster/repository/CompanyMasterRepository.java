package com.java.companymaster.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.java.companymaster.model.CompanyMaster;

public interface CompanyMasterRepository extends JpaRepository<CompanyMaster, Integer> {

	@Query("SELECT name FROM CompanyMaster")
	public List<CompanyMaster> findCompanyList();

	@Query("SELECT mf11_deactivatedOn FROM CompanyMaster cust where cust.id= ?#{[0]}")
	public String findById(Integer id);
	
	@Query(value = "SELECT id from CompanyMaster cust where cust.name = :name")
	public Integer findByName(@Param("name") String name);
}
