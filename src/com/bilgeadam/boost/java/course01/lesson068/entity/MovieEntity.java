package com.bilgeadam.boost.java.course01.lesson068.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "movies")
public class MovieEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	private long id;
	private String name;
	private int year;
	
	@OneToOne
	@JoinColumn(name = "link_id")
	private LinkEntity links;
	
	@ManyToMany
	@JoinTable(name = "movies_genres", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "genre_id"))
	private List<GenreEntity> genres;
	
	public void addGenre(GenreEntity genre) {
		if (this.genres == null) {
			this.genres = new ArrayList<GenreEntity>();
		}
		this.genres.add(genre);
	}
	
	@ManyToMany
	@JoinTable(name = "movies_ratings", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "id"))
	private List<MovieRating> movieRatings = new ArrayList<>();
	
	public void addMovieRating(MovieRating movieRating) {
		this.movieRatings.add(movieRating);
	}
	
	@OneToMany(mappedBy = "movie", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private List<MoviesUsersTag> movieTags = new ArrayList<>();
}