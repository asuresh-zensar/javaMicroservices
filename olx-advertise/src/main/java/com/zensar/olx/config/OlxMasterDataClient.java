package com.zensar.olx.config;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.zensar.olx.model.AdvStatus;
import com.zensar.olx.model.CategoryResponse;

@FeignClient("GATEWAY-SERVICE")
public interface OlxMasterDataClient {

	@GetMapping("/masterdataapi/category")
	List<CategoryResponse> getCategory();
	@GetMapping("/masterdataapi/status")
	public List<AdvStatus> getstatus();
	
	@GetMapping("/masterdataapi/category/{id}")
	public CategoryResponse getCategoryById(@PathVariable int id);
	@GetMapping("/masterdataapi/status/{id}")
	public AdvStatus getstatusById(@PathVariable int id);
}
