package com.cafe24.lms.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("C")
@PrimaryKeyJoinColumn(name = "book_id")
public class Book extends Item {

	@Column(name = "isbn", nullable = false)
	private String isbn;

	@ManyToOne
	@JoinColumn(name = "book_category_no")
	private BookCategory category;

	public BookCategory getCategory() {
		return category;
	}

	public void setCategory(BookCategory category) {
		this.category = category;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", bookCategory=" + category + ", getId()=" + getId() + ", isRent()=" + isRent()
				+ ", getName()=" + getName() + ", getPrice()=" + getPrice() + "]";
	}

}
