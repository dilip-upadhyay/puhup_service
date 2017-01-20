package com.agr.puhup.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agr.puhup.model.Address;

@Transactional
public interface AddressDao extends JpaRepository<Address, Long> {
}
