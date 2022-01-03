package com.zensar.olx.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.olx.model.AdvStatus;
import com.zensar.olx.model.Categories;
import com.zensar.olx.model.CategoryResponse;
import com.zensar.olx.repository.OlxAdvStatusRepository;
import com.zensar.olx.repository.OlxCategoryRepository;
@Service
public class OlxMasterdataServiceImpl implements OlxMasterdataService {
	@Autowired
	private OlxCategoryRepository catRepository;
	
	@Autowired
	private OlxAdvStatusRepository statusRepository;
	

	@Override
	public Categories insertCategory(Categories categories) {
		// TODO Auto-generated method stub
		return catRepository.save(categories);
	}

	@Override
	public AdvStatus insertAdvStatus(AdvStatus advStatus) {
		// TODO Auto-generated method stub
		return statusRepository.save(advStatus);
	}

	@Override
	public CategoryResponse getCategoryById(int id) {
		CategoryResponse catRes=new CategoryResponse();
		Categories cat=catRepository.findById(id).get();
		if(cat !=null) {
			catRes.setId(cat.getId());
			catRes.setCategory(cat.getName());
		}
		
		return catRes;
	}

	@Override
	public AdvStatus getStatusById(int id) {
		// TODO Auto-generated method stub
		return statusRepository.findById(id).get();
	}


	@Override
	public List<AdvStatus> getstatus() {
		// TODO Auto-generated method stub
		return statusRepository.findAll();
	}

	@Override
	public List<CategoryResponse> getCategory() {
		List<CategoryResponse> catResponses=new ArrayList<CategoryResponse>();
		List<Categories> categories=catRepository.findAll();
		if(categories!=null) {
			for (Categories category:categories) {
				catResponses.add(new CategoryResponse(category.getId(),category.getName()));
			}
		}
		return catResponses;
	}



}
