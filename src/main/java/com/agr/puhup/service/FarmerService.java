package com.agr.puhup.service;

import java.util.List;

import com.agr.puhup.model.Farmer;

public interface FarmerService {
	public void save(Farmer farmer);

	public Farmer getById(Long id);

	List<Farmer> findByFirstAndLastName(String firstName, String lastName);
}
