package com.java.companymaster.resource;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.java.companymaster.model.CompanyMaster;
import com.java.companymaster.model.Stores;
import com.java.companymaster.repository.CompanyMasterRepository;
import com.java.companymaster.repository.StoresRepository;

@Controller
public class MasterResource {
	
	@Autowired
	CompanyMasterRepository master;
	
	@Autowired
	StoresRepository storesRepository;

	@PreAuthorize("hasAnyRole('admin')")
    @RequestMapping("/")
    public String hello(ModelMap model) {
		model.addAttribute("getStoreInfo",storesRepository.findAll());
		model.addAttribute("companyList",master.findCompanyList());
        return "index";
    }
	
    @RequestMapping("/addUser")
    public String getUserForm()
    {
    	return "AddUser";
    }
    
    @RequestMapping(value="/addUser",method=RequestMethod.POST)
    public String postAddUser(@ModelAttribute("mf11_compCodeHRIS") String compHRISCode,
    		@ModelAttribute("mf11_compName") String compName,
    		@ModelAttribute("mf11_compAbbrName") String CompAbbrName,
    		@ModelAttribute("mf11_compRegNo") String CompRegNo,
    		@ModelAttribute("mf11_compLogo") String logo,
    		@ModelAttribute("mf11_isActive")boolean isActive,
    		@ModelAttribute("mf11_compCode") Integer compCode)
    {
    	
    	//Date Format
    	Date date = new Date();  
        Timestamp ts=new Timestamp(date.getTime());  
        SimpleDateFormat currdate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); 
        
    	Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
    	CompanyMaster companyMaster=new CompanyMaster();
    	
    	if(!isActive) {
    		companyMaster.setMf11_deactivatedBy(authentication.getName());
    		companyMaster.setMf11_deactivatedOn(currdate.format(ts).toString());
    	}
    
    	companyMaster.setMf11_compCode(compCode);
    	companyMaster.setMf11_compCodeHRIS(compHRISCode);
    	companyMaster.setMf11_compName(compName);
    	companyMaster.setMf11_compAbbrName(CompAbbrName);
    	companyMaster.setMf11_compRegNo(CompRegNo);
    	companyMaster.setMf11_compLogo(logo);
    	companyMaster.setMf11_isActive(isActive);
    	companyMaster.setMf11_createdOn(currdate.format(ts).toString());
    	companyMaster.setMf11_createdBy(authentication.getName());
    	companyMaster.setMf11_lastModifiedOn(currdate.format(ts).toString());
    	companyMaster.setMf11_lastModifiedBy(authentication.getName());
    	master.save(companyMaster);
    	return "redirect:/GoToUserList";
    }
    
    @RequestMapping("/GoToUserList")
    public String getUserList(Model model)
    {
    	
    	model.addAttribute("ListUser", master.findAll());
    	return "UserList";
    }
    
    @RequestMapping(value="/editUser",method=RequestMethod.POST)
    public String updateUser(@ModelAttribute("compCodeHRIS")String compCode,
    		@ModelAttribute("compName")String compName,
    		@ModelAttribute("compAbbrName")String CompAbbrName,
    		@ModelAttribute("compRegNo")String CompRegNo,
    		@ModelAttribute("compLogo")String logo,
    		@ModelAttribute("isActive")boolean isActive,
    		@ModelAttribute("createdOn")String createdOn,
    		@ModelAttribute("createdBy")String createdBy,
    		@ModelAttribute("compCode")Integer codeId,
    		@ModelAttribute("companyId")Integer companyId)
    		
    	{
    	
    	//Date Format
    	Date date = new Date();  
        Timestamp ts=new Timestamp(date.getTime());  
        SimpleDateFormat currdate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); 

    	Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
    	CompanyMaster updateRecord=new CompanyMaster();
    	System.out.println("isActive "+isActive);
    	String str= master.findById(companyId);
    	System.out.println("master.findById(companyId) "+str);
    	if(!isActive) {
    		updateRecord.setMf11_deactivatedBy(authentication.getName());
    		updateRecord.setMf11_deactivatedOn(currdate.format(ts).toString());
    	}
    	if(isActive && master.findById(companyId)!=null) {
    		updateRecord.setMf11_reactivatedBy(authentication.getName());
    		updateRecord.setMf11_reactivatedOn(currdate.format(ts).toString());
    		updateRecord.setMf11_deactivatedBy(authentication.getName());
    		updateRecord.setMf11_deactivatedOn(str);
    	}
    	
    	
    	
    	updateRecord.setId(companyId);
    	updateRecord.setMf11_compCode(codeId);
    	updateRecord.setMf11_compCodeHRIS(compCode);
    	updateRecord.setMf11_compName(compName);
    	updateRecord.setMf11_compAbbrName(CompAbbrName);
    	updateRecord.setMf11_compRegNo(CompRegNo);
    	updateRecord.setMf11_compLogo(logo);
    	updateRecord.setMf11_isActive(isActive);
    	updateRecord.setMf11_createdBy(createdBy);
    	updateRecord.setMf11_createdOn(createdOn);
    	updateRecord.setMf11_lastModifiedOn(currdate.format(ts).toString());
    	updateRecord.setMf11_lastModifiedBy(authentication.getName());
    	
    	master.save(updateRecord);
    	return "redirect:/GoToUserList";
    }
    
    @RequestMapping("/deleteUser")
    public String getDeleteDetail(@RequestParam("mf11_companyIdDel")Integer code)
    {
    	master.delete(code);
    	return "redirect:/GoToUserList";
    }
    
    // Add new store
    @RequestMapping("/addStore")
    public String addNewStoreInfo(Model model)
    {
    	model.addAttribute("companyList", master.findCompanyList());
    	return "AddStore";
    }
    
    @RequestMapping(value="/addStore",method=RequestMethod.POST)
    public String postAddUser(@ModelAttribute("mf11_storeCode")Integer storeCode,
    		@ModelAttribute("mf11_storeName")String storeName,
    		@ModelAttribute("mf11_storeAbbr")String storeAbbr,
    		@ModelAttribute("mf11_companyName")String companyName)
    {
    	Stores stores =new Stores(); 
    	stores.setMf11_storeCode(storeCode);
    	stores.setMf11_storeName(storeName);
    	stores.setMf11_storeAbbr(storeAbbr);
    	stores.setMf11_companyName(companyName);
    	storesRepository.save(stores);
    	return "redirect:/";
    }
    
    @RequestMapping(value="/editStoreInfo", method=RequestMethod.POST)
    public String updateStore(
    		@ModelAttribute("storeCode")Integer storeCode,
    		@ModelAttribute("storeName")String storeName,
    		@ModelAttribute("storeAbbr")String storeAbbr,
    		@ModelAttribute("companyList")String selectedCompany,
    		@ModelAttribute("storeId")Integer id)
    {    	
    	Stores store =new Stores();
    	store.setId(id);
    	store.setMf11_storeCode(storeCode);
    	store.setMf11_storeName(storeName);
    	store.setMf11_storeAbbr(storeAbbr);
    	store.setMf11_companyName(selectedCompany);
    	storesRepository.save(store);
    	return "redirect:/";
    }
    
    @RequestMapping("/deleteStoreInfo")
    public String deleteStore(@RequestParam("mf11_storeIdDel")Integer storeCode)
    {
    	storesRepository.delete(storeCode);
    	return "redirect:/";
    } 
    
    @PreAuthorize("hasAnyRole('admin')")
    @RequestMapping("/secured/all")
    public String securedHello() {
        return "Secured Hello";
    }
    
    @RequestMapping("/back")
    public String back()
    {
    	return "redirect:/";
    } 
}