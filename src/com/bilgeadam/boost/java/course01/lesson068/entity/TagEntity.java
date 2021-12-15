package com.bilgeadam.boost.java.course01.lesson068.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tags")
public class TagEntity {
	@Id
	private long id;
	@Column(name = "tag")
	private String tag;
	
	@OneToMany(mappedBy = "tag", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private List<MoviesUsersTag> tags = new ArrayList<>();
	
	public void addMovieTag(MoviesUsersTag tag) {
		this.tags.add(tag);
	}
	
}