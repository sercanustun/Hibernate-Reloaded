package com.bilgeadam.boost.java.course01.lesson068.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "movies_ratings")
public class MovieRating {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long  id;

	@ManyToMany
	@JoinColumn(name = "movie_id")
	@ToString.Exclude
	private List<MovieEntity> movies;

	@ManyToMany
	@JoinColumn(name = "user_id")
//	@ToString.Exclude
	private List<UserEntity> users;
	
	private float rating;
	@Temporal(TemporalType.TIMESTAMP)
	private Date  rated_at;
	
	public void addMovie(MovieEntity movie) {
		if (this.movies == null) {
			this.movies = new ArrayList<MovieEntity>();
		}
		this.movies.add(movie);
	}

	public void addUser(UserEntity user) {
		if (this.users == null) {
			this.users = new ArrayList<UserEntity>();
		}
		this.users.add(user);
	}
	
}
