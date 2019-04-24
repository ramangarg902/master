package com.java.companymaster.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.java.companymaster.model.Stores;

public interface StoresRepository extends JpaRepository<Stores, Integer> {

	@Transactional
	@Modifying
	//@Query(value = "delete from Stores s WHERE s.companyId = :companyId")
	public void deleteByCompanyId(Integer companyId);

	public Stores findByCompanyId(@Param("companyId") Integer companyId);
	
	public Stores findById(Integer id);
}
