package com.zensar.olx.service;

import java.util.List;


import com.zensar.olx.model.Advertises;

public interface OlxAdvertiseService {

	public Advertises insertAdvertise(Advertises advertises) ;
	public Advertises updateAdvertises(Advertises advertises,int id);
	public List<Advertises> getAdvertises();
	public Advertises getAdvertisesById(int id) ;
	public boolean deleteAdvertises(int id);
}
