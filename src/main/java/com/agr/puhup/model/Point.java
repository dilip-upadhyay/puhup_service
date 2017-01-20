/**
 * 
 */
package com.agr.puhup.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.agr.puhup.model.security.User;

/**
 * @author Dilip Upadhyay
 *
 */
@Entity
@Table(name = "POINT")
public class Point {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	// @NotNull
	private int assignedPoint;

	// @NotNull
	private int usedPoint;

	@OneToOne(mappedBy = "point", fetch = FetchType.LAZY)
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAssignedPoint() {
		return assignedPoint;
	}

	public void setAssignedPoint(int assignedPoint) {
		this.assignedPoint = assignedPoint;
	}

	public int getUsedPoint() {
		return usedPoint;
	}

	public void setUsedPoint(int usedPoint) {
		this.usedPoint = usedPoint;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
