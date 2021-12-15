package com.bilgeadam.boost.java.course01.lesson068.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "movies_tags")
public class MoviesUsersTag {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "movie_id")
	private MovieEntity movie;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;
	
	@ManyToOne
	@JoinColumn(name = "tag_id")
	private TagEntity tag;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date tagged_at;
	
	@Override
	public String toString() {
		return "MoviesUsersTag [id=" + this.id + ", tagged_at=" + this.tagged_at + ", getMovie()="
				+ this.getMovie().getName() + ", getUser()=" + this.getUser().getName() + ", getTag()="
				+ this.getTag().getTag() + "]";
	}
}