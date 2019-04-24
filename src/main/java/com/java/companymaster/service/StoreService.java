package com.java.companymaster.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.companymaster.model.Stores;
import com.java.companymaster.repository.CompanyMasterRepository;
import com.java.companymaster.repository.StoresRepository;

@Service
public class StoreService {

	@Autowired
	CompanyMasterRepository master;

	@Autowired
	StoresRepository storeRepository;

	public List<Stores> getAllStores() {
		return storeRepository.findAll();
	}

	public void deleteStoreByCompanyId(Integer companyId) {
		if (storeRepository.findByCompanyId(companyId) != null) {
			storeRepository.deleteByCompanyId(companyId);
		} else {
			System.err.println("Store not found !!");
		}
	}

	public void addStore(Stores store) {
		store.setCompanyId(master.findByName(store.getMf11_companyName()));
		storeRepository.save(store);
	}

	public void updateStore(Stores store) {
		Stores updatedStore = storeRepository.findById(store.getId());
		if (updatedStore != null) {
			updatedStore.setMf11_companyName(store.getMf11_companyName());
			updatedStore.setMf11_storeAbbr(store.getMf11_storeAbbr());
			updatedStore.setMf11_storeCode(store.getMf11_storeCode());
			updatedStore.setMf11_storeName(store.getMf11_storeName());
			updatedStore.setCompanyId(master.findByName(updatedStore.getMf11_companyName()));
			storeRepository.save(updatedStore);
		}
	}

	public void deleteStoreById(Integer id) {
		storeRepository.delete(id);
	}
}
