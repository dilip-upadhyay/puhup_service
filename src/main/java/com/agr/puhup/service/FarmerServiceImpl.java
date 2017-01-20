package com.agr.puhup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agr.puhup.model.Farmer;
import com.agr.puhup.repository.FarmerDao;
@Service
public class FarmerServiceImpl implements FarmerService {
	@Autowired
	FarmerDao farmerDao;

	@Override
	public void save(Farmer farmer) {
		farmerDao.save(farmer);
	}

	@Override
	public Farmer getById(Long id) {
		return farmerDao.findOne(id);
	}

	@Override
	public List<Farmer> findByFirstAndLastName(String firstName, String lastName) {
		return farmerDao.findByFirstAndLastName(firstName, lastName);
	}
}