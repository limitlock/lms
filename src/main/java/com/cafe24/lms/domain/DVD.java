package com.cafe24.lms.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue("B")
@PrimaryKeyJoinColumn(name = "dvd_id")
public class DVD extends Item {

	@Column(name = "company", nullable = false)
	private String company;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Music [company=" + company + ", getId()=" + getId() + ", getName()=" + getName() + ", getPrice()="
				+ getPrice() + "]";
	}

}
