package com.java.companymaster.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.companymaster.model.CompanyMaster;
import com.java.companymaster.model.Stores;
import com.java.companymaster.service.CompanyMasterService;
import com.java.companymaster.service.StoreService;

@Controller
public class MasterResource {

	@Autowired
	CompanyMasterService companyMasterService;

	@Autowired
	StoreService storeService;

	// private final Logger LOGGER = LoggerFactory.getLogger(MasterResource.class);

	@PreAuthorize("hasAnyRole('admin')")
	@RequestMapping("/")
	public String hello(ModelMap model) {
		System.err.println("Inside ROOT  :: ADD STORE");
		model.addAttribute("getStoreInfo", storeService.getAllStores());
		model.addAttribute("companyList", companyMasterService.getCompanyNameList());
		return "index";
	}

	@RequestMapping(value = "/addUser")
	public String addCompanyMasterForm() {
		return "AddUser";
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String postAddCompanyMaster(@RequestBody CompanyMaster companyMaster) {
		companyMasterService.createCompanyMaster(companyMaster);
		return "redirect:/GoToUserList";
	}

	@RequestMapping(value = "/GoToUserList")
	public String getCompanyMastersList(Model model) {
		model.addAttribute("ListUser", companyMasterService.getAllCompanies());
		return "UserList";
	}

	@RequestMapping(value = "/editUser", method = RequestMethod.POST)
	public String updateCompanyMaster(@RequestBody CompanyMaster companyMaster) {
		return "redirect:/GoToUserList";
	}

	@RequestMapping(value = "/deleteUser")
	public String deleteCompanyMaster(@RequestParam("mf11_companyIdDel") Integer id) {
		storeService.deleteStoreByCompanyId(id);
		companyMasterService.deleteCompanyMasterById(id);
		return "redirect:/GoToUserList";
	}

	// Add new store
	@RequestMapping(value = "/addStore")
	public String addStoreForm(Model model) {
		model.addAttribute("companyList", companyMasterService.getCompanyNameList());
		return "AddStore";
	}

	@RequestMapping(value = "/addStore", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Stores postAddStore(@RequestBody Stores store) {
		storeService.addStore(store);
		return store;
	}

	@RequestMapping(value = "/editStoreInfo")
	public String editStore(@RequestBody Stores store) {
		storeService.updateStore(store);
		return "redirect:/";
	}

	@RequestMapping(value = "/deleteStoreInfo")
	public String deleteStore(@RequestParam("mf11_storeIdDel") Integer storeCode) {
		storeService.deleteStoreById(storeCode);
		return "redirect:/";
	}

	@PreAuthorize("hasAnyRole('admin')")
	@RequestMapping(value = "/secured/all")
	public String securedHello() {
		return "Secured Hello";
	}

	@RequestMapping(value = "/back")
	public String back() {
		return "redirect:/";
	}
}