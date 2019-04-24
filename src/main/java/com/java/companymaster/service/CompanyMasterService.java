package com.java.companymaster.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.java.companymaster.model.CompanyMaster;
import com.java.companymaster.repository.CompanyMasterRepository;

@Service
public class CompanyMasterService {

	@Autowired
	CompanyMasterRepository master;

	public void createCompanyMaster(CompanyMaster companyMaster) {

		// Date Format
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		SimpleDateFormat currdate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (!companyMaster.isMf11_isActive()) {
			companyMaster.setMf11_deactivatedBy(authentication.getName());
			companyMaster.setMf11_deactivatedOn(currdate.format(ts).toString());
		}
		companyMaster.setMf11_compCode(companyMaster.getMf11_compCode());
		companyMaster.setMf11_compCodeHRIS(companyMaster.getMf11_compCodeHRIS());
		companyMaster.setName(companyMaster.getName());
		companyMaster.setMf11_compAbbrName(companyMaster.getMf11_compAbbrName());
		companyMaster.setMf11_compRegNo(companyMaster.getMf11_compRegNo());
		companyMaster.setMf11_compLogo(companyMaster.getMf11_compLogo());
		companyMaster.setMf11_isActive(companyMaster.isMf11_isActive());
		companyMaster.setMf11_createdOn(currdate.format(ts).toString());
		companyMaster.setMf11_createdBy(authentication.getName());
		companyMaster.setMf11_lastModifiedOn(currdate.format(ts).toString());
		companyMaster.setMf11_lastModifiedBy(authentication.getName());
		master.save(companyMaster);

	}
	
	public List<CompanyMaster> getCompanyNameList() {
		return master.findCompanyList();
	}
	
	public List<CompanyMaster> getAllCompanies() {
		return master.findAll();
	}
	
	public void editCompanyMaster(CompanyMaster companyMaster) {
		// Date Format
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		SimpleDateFormat currdate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		CompanyMaster updateRecord = new CompanyMaster();
		System.out.println("isActive " + companyMaster.isMf11_isActive());
		String str = master.findById(companyMaster.getMf11_compCode());
		System.out.println("master.findById(companyId) " + str);
		if (companyMaster.isMf11_isActive()) {
			updateRecord.setMf11_deactivatedBy(authentication.getName());
			updateRecord.setMf11_deactivatedOn(currdate.format(ts).toString());
		}
		if (companyMaster.isMf11_isActive() && master.findById(companyMaster.getMf11_compCode()) != null) {
			updateRecord.setMf11_reactivatedBy(authentication.getName());
			updateRecord.setMf11_reactivatedOn(currdate.format(ts).toString());
			updateRecord.setMf11_deactivatedBy(authentication.getName());
			updateRecord.setMf11_deactivatedOn(str);
		}

//		updateRecord.setId(companyId);
//		updateRecord.setMf11_compCode(codeId);
//		updateRecord.setMf11_compCodeHRIS(compCode);
//		updateRecord.setMf11_compName(compName);
//		updateRecord.setMf11_compAbbrName(CompAbbrName);
//		updateRecord.setMf11_compRegNo(CompRegNo);
//		updateRecord.setMf11_compLogo(logo);
//		updateRecord.setMf11_isActive(isActive);
//		updateRecord.setMf11_createdBy(createdBy);
//		updateRecord.setMf11_createdOn(createdOn);
//		updateRecord.setMf11_lastModifiedOn(currdate.format(ts).toString());
//		updateRecord.setMf11_lastModifiedBy(authentication.getName());

		master.save(updateRecord);
		
	}
	
	public void deleteCompanyMasterById(Integer id) {
		master.delete(id);
	}
}
