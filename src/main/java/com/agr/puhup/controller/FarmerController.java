package com.agr.puhup.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.agr.puhup.model.Farmer;
import com.agr.puhup.service.FarmerService;

@RestController
@EnableAutoConfiguration
public class FarmerController {
	@Autowired
	FarmerService farmerService;

	@PreAuthorize("hasRole('ROLE_EMPLOYEE') || hasRole('ROLE_ADMIN')")
	@RequestMapping(path = "/farmer", method = RequestMethod.POST)
	public Farmer registerFarmer(@RequestBody Farmer enFarmer) throws ParseException {

		String birthDate = enFarmer.getBirthDate();
		if (birthDate != null && !birthDate.isEmpty()) {
			DateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
			Date dob = (Date) formatter.parse(birthDate);
			enFarmer.setDob(dob);
		}
		farmerService.save(enFarmer);
		return enFarmer;

	}
	@PreAuthorize("hasRole('ROLE_EMPLOYEE') || hasRole('ROLE_ADMIN')")
	@RequestMapping(path = "/farmer/{id}", method = RequestMethod.PUT)
	public Farmer editFarmer(@PathVariable(value = "id") Long id, @RequestBody Farmer enFarmer) throws ParseException {
		Farmer dbFarmer = farmerService.getById(id);
		updateChangedValues(dbFarmer, enFarmer);
		String birthDate = enFarmer.getBirthDate();
		if (birthDate != null && !birthDate.isEmpty()) {
			DateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
			Date dob = (Date) formatter.parse(birthDate);
			enFarmer.setDob(dob);
		}
		// enFarmer.setId(id);
		farmerService.save(dbFarmer);
		return enFarmer;
	}

	private void updateChangedValues(Farmer dbFarmer, Farmer enFarmer) {
		if (enFarmer.getFirstName() != null)
			dbFarmer.setFirstName(enFarmer.getFirstName());
		dbFarmer.setMiddleName(enFarmer.getMiddleName());
		if (enFarmer.getLastName() != null)
			dbFarmer.setLastName(enFarmer.getLastName());
		if (enFarmer.getGender() != null)
			dbFarmer.setGender(enFarmer.getGender());

		if (enFarmer.getBirthDate() != null)
			dbFarmer.setGender(enFarmer.getGender());

	}

	@RequestMapping(path = "/farmer/{id}", method = RequestMethod.GET)
	public Farmer findFarmerById(@PathVariable(value = "id") Long id) {

		return farmerService.getById(id);
	}

	@RequestMapping(path = "/farmer", method = RequestMethod.GET)
	public List<Farmer> findByFirstAndLastName(@RequestParam(value = "firstname") String firstName,
			@RequestParam(value = "lastname") String lastName) {
		return farmerService.findByFirstAndLastName(firstName, lastName);

	}
}
