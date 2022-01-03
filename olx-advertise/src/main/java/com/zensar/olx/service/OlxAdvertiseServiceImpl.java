package com.zensar.olx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.olx.model.Advertises;
import com.zensar.olx.repository.OlxAdvertiserRepository;
@Service
public class OlxAdvertiseServiceImpl implements OlxAdvertiseService {

	@Autowired
	private OlxAdvertiserRepository advRepository;

	@Override
	public Advertises insertAdvertise(Advertises advertises) {
		// TODO Auto-generated method stub
		return advRepository.save(advertises);
	}

	@Override
	public Advertises updateAdvertises(Advertises advertises, int id) {
		
		return null;
	}

	@Override
	public List<Advertises> getAdvertises() {
		// TODO Auto-generated method stub
		return advRepository.findAll();
	}

	@Override
	public Advertises getAdvertisesById(int id) {
		// TODO Auto-generated method stub
		return advRepository.getById(id);
	}

	@Override
	public boolean deleteAdvertises(int id) {
		// TODO Auto-generated method stub
		try{
			advRepository.deleteById(id);
			return Boolean.TRUE;
		}catch (Exception e) {
			// TODO: handle exception
			return Boolean.FALSE;
		}
	}

}
