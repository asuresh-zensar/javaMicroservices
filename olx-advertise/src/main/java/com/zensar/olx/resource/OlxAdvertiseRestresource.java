package com.zensar.olx.resource;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.olx.config.OlxMasterDataClient;
import com.zensar.olx.model.AdvStatus;
import com.zensar.olx.model.AdvertiseResponse;
import com.zensar.olx.model.Advertises;
import com.zensar.olx.model.CategoryResponse;
import com.zensar.olx.service.OlxAdvertiseService;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/advertise")
public class OlxAdvertiseRestresource {
	
	@Autowired
	private OlxMasterDataClient client;
	@Autowired
	private OlxAdvertiseService advService;

	@PostMapping("")
	@Retry(name="create-advertisement", fallbackMethod="handleCreateError")
	public AdvertiseResponse insertAdvertise(@RequestBody Advertises advertises) {
		if(advertises.getCreatedDate()==null){
			advertises.setCreatedDate(LocalDate.now());
		}
		if(advertises.getModifiedDate()==null) {
			advertises.setModifiedDate(LocalDate.now());
		}
		if(advertises.getStatus()==0) {
			advertises.setStatus(1);
		}
		Advertises adv=advService.insertAdvertise(advertises);
		AdvertiseResponse response=new AdvertiseResponse();
		if(adv!=null) {
			response=generateAdvertiseResponse(adv);
		}
		return response;
	}
	
	@PutMapping("/{id}")
	@Retry(name="update-advertisement", fallbackMethod="handleUpdateError")
	public AdvertiseResponse updateAdvertises(@RequestBody Advertises advertises,@PathVariable int id) {
		Advertises adv=advService.getAdvertisesById(id);
		Advertises advterise=null;
		if(adv!=null) {
			adv.setTitle(advertises.getTitle());
			adv.setCategory(advertises.getCategory());
			adv.setActive(advertises.isActive());
			adv.setModifiedDate(LocalDate.now());
			adv.setPrice(advertises.getPrice());
			adv.setUsername(advertises.getUsername());
			adv.setPostedBy(advertises.getPostedBy());
			if(advertises.getStatus()!=0) {
				adv.setStatus(advertises.getStatus());
			}
			advterise= advService.insertAdvertise(adv);
		}else {
			if(advertises.getCreatedDate()==null){
				advertises.setCreatedDate(LocalDate.now());
			}
			if(advertises.getModifiedDate()==null) {
				advertises.setModifiedDate(LocalDate.now());
			}
			if(advertises.getStatus()==0) {
				advertises.setStatus(1);
			}
			advterise=advService.insertAdvertise(advertises);
		}
		AdvertiseResponse response=new AdvertiseResponse();
		if(advterise!=null) {
			response=generateAdvertiseResponse(advterise);
		}
		return response;
	}
	@GetMapping("")
	@Retry(name="get-advertisements", fallbackMethod="handlegetError")
	public List<AdvertiseResponse> getAdvertises() {
		//System.out.print(template.getForObject("http://localhost:9000/masterdataapi/category", List.class));
		System.out.print(client.getCategory());
		List<AdvertiseResponse> response=new ArrayList<AdvertiseResponse>();
		List<Advertises> advertises=advService.getAdvertises();
		if(advertises!=null) {
			for(Advertises adv:advertises) {
				response.add(generateAdvertiseResponse(adv));
			}
		}
		return response;
	}
	@GetMapping("/{id}")
	@Retry(name="getbyId-advertisement", fallbackMethod="handlegetByIdError")
	public AdvertiseResponse getAdvertisesById(@PathVariable int id) {
		
		Advertises adv=advService.getAdvertisesById(id);
		AdvertiseResponse response=new AdvertiseResponse();
		if(adv!=null) {
			response=generateAdvertiseResponse(adv);
		}
		return response;
	}
	@DeleteMapping("/{id}")
	public boolean deleteAdvertises(@PathVariable int id) {
		return advService.deleteAdvertises(id);
	}
	@GetMapping("/category")
	@Retry(name="get-category", fallbackMethod="handleGetCategoryError")
	List<CategoryResponse> getCategory(){
		return client.getCategory();
	}
	@GetMapping("/status")
	@Retry(name="get-status", fallbackMethod="handleGetStatusError")
	public List<AdvStatus> getstatus(){
		return client.getstatus();
	}
	
	public AdvertiseResponse generateAdvertiseResponse(Advertises advertises) {
		if(advertises!=null) {
			return new AdvertiseResponse(advertises.getId(), advertises.getTitle(), client.getCategoryById(advertises.getCategory()).getCategory(), client.getstatusById(advertises.getStatus()).getStatus(), advertises.getPrice(), advertises.getDescription(),
					advertises.getPhoto(), advertises.getCreatedDate(), advertises.getModifiedDate(), advertises.isActive(), advertises.getPostedBy(),
					advertises.getUsername());
		}
		return new AdvertiseResponse();
	}
	public AdvertiseResponse handleCreateError(Advertises adv,Exception exception) {
		return new AdvertiseResponse();
		
	}
	public AdvertiseResponse handleUpdateError(Advertises adv,int id,Exception exception) {
		return new AdvertiseResponse();
		
	}
	public List<AdvertiseResponse> handlegetError(Exception e) {
		return new ArrayList<AdvertiseResponse>();
		
	}
	public AdvertiseResponse handlegetByIdError(int id,Exception e) {
		return new AdvertiseResponse();
		
	}
	public List<CategoryResponse> handleGetCategoryError(Exception exception) {
		return new ArrayList<CategoryResponse>();
		
	}
	public List<AdvStatus> handleGetStatusError(Exception exception) {
		return new ArrayList<AdvStatus>();
		
	}
}
