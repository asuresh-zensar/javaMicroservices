package com.zensar.olx.service;

import java.util.List;


import com.zensar.olx.model.AdvStatus;
import com.zensar.olx.model.Categories;
import com.zensar.olx.model.CategoryResponse;

public interface OlxMasterdataService {

	public Categories insertCategory(Categories categories) ;
	public AdvStatus insertAdvStatus(AdvStatus advStatus);
	public CategoryResponse getCategoryById(int id);
	public AdvStatus getStatusById( int id);
	public List<CategoryResponse> getCategory() ;
	public List<AdvStatus> getstatus();
}
