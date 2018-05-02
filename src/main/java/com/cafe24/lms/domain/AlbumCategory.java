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
@Table(name = "album_category")
public class AlbumCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long no;

	private String name;

	@OneToMany
	@JoinColumn(name = "category_no")
	private List<Album> albums = new ArrayList<Album>();

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

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

	@Override
	public String toString() {
		return "AlbumCategory [no=" + no + ", name=" + name + ", albums=" + albums + "]";
	}

}
