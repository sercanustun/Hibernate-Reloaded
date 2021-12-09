package com.bilgeadam.boost.java.course01.lesson068.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "genres")
public class GenreEntity {
	@Id 
	private long   id;
	
	@Column(name = "genre")
	private String genre;
	
//	@ManyToMany(mappedBy = "genres")
	@ManyToMany
	private List<MovieEntity> movies;
	
	public void addMovie(MovieEntity movie) {
		if (this.movies == null) {
			this.movies = new ArrayList<MovieEntity>();
		}
		this.movies.add(movie);
	}
}
