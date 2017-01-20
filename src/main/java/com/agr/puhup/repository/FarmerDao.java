package com.agr.puhup.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.agr.puhup.model.Farmer;

@Transactional
public interface FarmerDao extends JpaRepository<Farmer, Long> {
	List<Farmer> findByLastName(String lastName);

	@Query("SELECT f FROM Farmer f WHERE LOWER(f.firstName) = LOWER(:firstName) AND LOWER(f.lastName) = LOWER(:lastName)")
	public List<Farmer> findByFirstAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);
}
