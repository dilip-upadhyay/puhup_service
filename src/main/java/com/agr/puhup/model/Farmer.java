/**
 * 
 */
package com.agr.puhup.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Dilip Upadhyay
 *
 */
@Entity
@Table(name = "FARMER")
public class Farmer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@Size(min = 2, max = 80)
	private String firstName;

	@Size(min = 2, max = 80)
	private String middleName;

	@NotNull
	@Size(min = 2, max = 80)
	private String lastName;

	@NotNull
	@Size(min = 1, max = 1)
	private String gender;

	@Transient
	private String birthDate;

	@NotNull
	private Date dob;

	@NotNull
	@Size(max = 15)
	private String landMeasurementUnit;

	@NotNull
	private Integer landSize;

	@OneToMany(targetEntity = Address.class, cascade = CascadeType.ALL)
	private List<Address> addresses;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getLandMeasurementUnit() {
		return landMeasurementUnit;
	}

	public void setLandMeasurementUnit(String landMeasurementUnit) {
		this.landMeasurementUnit = landMeasurementUnit;
	}

	public Integer getLandSize() {
		return landSize;
	}

	public void setLandSize(Integer landSize) {
		this.landSize = landSize;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return String.format("Customer[id=%d, firstName='%s', lastName='%s']", id, firstName, lastName);
	}
}
