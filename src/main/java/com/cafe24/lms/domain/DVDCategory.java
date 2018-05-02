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
@Table(name = "DVD_category")
public class DVDCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long no;

	private String name;

	@OneToMany
	@JoinColumn(name = "category_no")
	private List<DVD> DVDs = new ArrayList<DVD>();

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

	public List<DVD> getDVDs() {
		return DVDs;
	}

	public void setDVDs(List<DVD> dVDs) {
		DVDs = dVDs;
	}

	@Override
	public String toString() {
		return "DVDCategory [no=" + no + ", name=" + name + ", DVDs=" + DVDs + "]";
	}

}
