package com.cafe24.lms.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(RentId.class)
public class Rent {

	@Id
	@ManyToOne
	@JoinColumn(name = "user_no")
	private User user;

	@Id
	@ManyToOne
	@JoinColumn(name = "item_id")
	private Item item;

	private String LeaseDate;
	private String ReturnDate;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getLeaseDate() {
		return LeaseDate;
	}

	public void setLeaseDate(String leaseDate) {
		LeaseDate = leaseDate;
	}

	public String getReturnDate() {
		return ReturnDate;
	}

	public void setReturnDate(String returnDate) {
		ReturnDate = returnDate;
	}

	@Override
	public String toString() {
		return "Rent [user=" + user + ", item=" + item + ", LeaseDate=" + LeaseDate + ", ReturnDate=" + ReturnDate
				+ "]";
	}

}
