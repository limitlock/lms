package com.cafe24.lms.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "book_category")
public class BookCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long no;

	private String name;

	@OneToMany
	@JoinColumn(name = "category_no")
	private List<Book> books = new ArrayList<Book>();

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "BookCategory [no=" + no + ", name=" + name + ", books=" + books + "]";
	}

}
