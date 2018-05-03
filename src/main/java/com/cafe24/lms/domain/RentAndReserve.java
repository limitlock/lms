package com.cafe24.lms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
@IdClass(RentAndReserveId.class)
public class RentAndReserve {

	@Id
	@ManyToOne
	@JoinColumn(name = "user_no")
	private User user;

	@Id
	@ManyToOne
	@JoinColumn(name = "item_id")
	private Item item;

	private String leaseDate;

	private String returnDate;

	private Long userIndex;

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

	public Long getUserIndex() {
		return userIndex;
	}

	public void setUserIndex(Long userIndex) {
		this.userIndex = userIndex;
	}

	@Override
	public String toString() {
		return "RentAndReserve [user=" + user + ", item=" + item + ", leaseDate=" + leaseDate + ", returnDate="
				+ returnDate + ", userIndex=" + userIndex + "]";
	}

}
