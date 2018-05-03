package com.cafe24.lms.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue("A")
@PrimaryKeyJoinColumn(name = "album_id")
public class Album extends Item {

	private String artist;

	@ManyToOne
	@JoinColumn(name = "album_category_no")
	private AlbumCategory category;

	public AlbumCategory getCategory() {
		return category;
	}

	public void setCategory(AlbumCategory category) {
		this.category = category;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	@Override
	public String toString() {
		return "Album [artist=" + artist + ", albumCategory=" + category + ", getId()=" + getId() + ", isRent()="
				+ isRent() + ", getName()=" + getName() + ", getPrice()=" + getPrice() + "]";
	}

}
