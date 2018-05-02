package com.cafe24.lms.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("C")
@PrimaryKeyJoinColumn(name = "book_id")
public class Book extends Item {

	@Column(name = "isbn", nullable = false)
	private String isbn;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", getId()=" + getId() + ", getName()=" + getName() + ", getPrice()=" + getPrice()
				+ "]";
	}

}
