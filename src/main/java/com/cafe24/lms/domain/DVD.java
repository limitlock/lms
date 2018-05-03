package com.cafe24.lms.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue("B")
@PrimaryKeyJoinColumn(name = "dvd_id")
public class DVD extends Item {

	@Column(name = "company", nullable = false)
	private String company;

	@ManyToOne
	@JoinColumn(name = "dvd_category_no")
	private DVDCategory category;

	public DVDCategory getCategory() {
		return category;
	}

	public void setCategory(DVDCategory category) {
		this.category = category;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "DVD [company=" + company + ", dvdCategory=" + category + ", getId()=" + getId() + ", isRent()="
				+ isRent() + ", getName()=" + getName() + ", getPrice()=" + getPrice() + "]";
	}

}
