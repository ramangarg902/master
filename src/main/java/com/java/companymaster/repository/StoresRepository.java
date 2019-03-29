package com.java.companymaster.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.java.companymaster.model.CompanyMaster;
import com.java.companymaster.model.Stores;

public interface StoresRepository extends JpaRepository<Stores, Integer> {

}
