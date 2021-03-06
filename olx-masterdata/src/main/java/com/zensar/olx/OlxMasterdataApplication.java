package com.zensar.olx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.zensar.olx.model.AdvStatus;
import com.zensar.olx.model.Categories;
import com.zensar.olx.restresource.OlxMasterDataResource;

@SpringBootApplication
@EnableEurekaClient
public class OlxMasterdataApplication implements ApplicationRunner {
	@Autowired
	private OlxMasterDataResource masterdataResource;

	public static void main(String[] args) {
		SpringApplication.run(OlxMasterdataApplication.class, args);
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Categories cat=new Categories(1,"Furniture","Furniture data");
		masterdataResource.insertCategory(cat);
		cat=new Categories(2,"Cars","cars data");
		masterdataResource.insertCategory(cat);
		cat=new Categories(3,"Mobiles","Mobiles data");
		masterdataResource.insertCategory(cat);
		cat=new Categories(4,"Real Estate","Real Estate data");
		masterdataResource.insertCategory(cat);
		cat=new Categories(5,"Sports","Sports data");
		masterdataResource.insertCategory(cat);
		
		AdvStatus status=new AdvStatus(1,"OPEN");
		masterdataResource.insertAdvStatus(status);
		status=new AdvStatus(2,"CLOSED");
		masterdataResource.insertAdvStatus(status);
		
	}

}
