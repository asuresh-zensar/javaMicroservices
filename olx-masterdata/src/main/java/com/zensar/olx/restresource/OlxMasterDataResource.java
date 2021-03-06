package com.zensar.olx.restresource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.olx.model.AdvStatus;
import com.zensar.olx.model.Categories;
import com.zensar.olx.model.CategoryResponse;
import com.zensar.olx.service.OlxMasterdataService;

@RestController
@RequestMapping("/masterdataapi")
public class OlxMasterDataResource {

	@Autowired
	private OlxMasterdataService masterdataService;

	@PostMapping("/category")
	public Categories insertCategory(Categories categories) {
		return masterdataService.insertCategory(categories);
	}
	@PostMapping("/status")
	public AdvStatus insertAdvStatus(AdvStatus advStatus) {
		return masterdataService.insertAdvStatus(advStatus);
	}
	@GetMapping("/category/{id}")
	public CategoryResponse getCategoryById(@PathVariable int id) {
		return masterdataService.getCategoryById(id);
	}
	@GetMapping("/status/{id}")
	public AdvStatus getstatusById(@PathVariable int id) {
		return masterdataService.getStatusById(id);
	}

	@GetMapping("/category")
	public List<CategoryResponse> getCategory() {
		return masterdataService.getCategory();
	}
	@GetMapping("/status")
	public List<AdvStatus> getstatus() {
		return masterdataService.getstatus();
	}
}
