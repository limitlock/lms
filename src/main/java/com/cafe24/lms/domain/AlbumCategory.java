package com.cafe24.lms.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "album_category")
public class AlbumCategory {

	@Id
	@Column(name = "album_category_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long no;

	@Column(name = "name", nullable = false)
	private String name;

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

	@Override
	public String toString() {
		return "AlbumCategory [no=" + no + ", name=" + name + "]";
	}

}
