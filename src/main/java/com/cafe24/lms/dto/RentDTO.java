package com.cafe24.lms.dto;

import com.cafe24.lms.domain.Item;

public class RentDTO {

	private Item item;
	private String email;
	private String leaseDate;
	private String returnDate;
	private Long userIndex;

	public RentDTO(Item item, String email, String leaseDate, String returnDate, Long userIndex) {
		super();
		this.item = item;
		this.email = email;
		this.leaseDate = leaseDate;
		this.returnDate = returnDate;
		this.userIndex = userIndex;
	}

	public RentDTO() {
		// TODO Auto-generated constructor stub
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getEmail() {
		return email;
	}

	public Long getUserIndex() {
		return userIndex;
	}

	public void setUserIndex(Long userIndex) {
		this.userIndex = userIndex;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLeaseDate() {
		return leaseDate;
	}

	public void setLeaseDate(String leaseDate) {
		this.leaseDate = leaseDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	@Override
	public String toString() {
		return "RentDTO [item=" + item + ", email=" + email + ", leaseDate=" + leaseDate + ", returnDate=" + returnDate
				+ ", userIndex=" + userIndex + "]";
	}

}
