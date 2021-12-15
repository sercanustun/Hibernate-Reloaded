package com.bilgeadam.boost.java.course01.lesson068.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "users")
public class UserEntity {
	@Id
	private long id;
	@Column(name = "name")
	private String name;
	
	@ManyToMany
	@JoinTable(name = "movies_ratings", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "id"))
	private List<MovieRating> movieRatings = new ArrayList<>();
	
	public void addMovieRating(MovieRating movieRating) {
		this.movieRatings.add(movieRating);
	}
	
	// @ManyToMany
	// @JoinTable(name = "movies_tags", joinColumns = @JoinColumn(name = "user_id"),
	// inverseJoinColumns = @JoinColumn(name = "id"))
	@OneToMany(mappedBy = "user", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private List<MoviesUsersTag> movieTags = new ArrayList<>();
	
	public void addMovieTag(MoviesUsersTag tag) {
		this.movieTags.add(tag);
	}
}