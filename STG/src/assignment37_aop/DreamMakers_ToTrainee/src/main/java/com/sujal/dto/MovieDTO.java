package com.sujal.dto;

import java.time.LocalDate;

import lombok.Data;
@Data
public class MovieDTO {
	
	private String movieId;
	private String movieName;
	private String language;
	private LocalDate releasedIn;
	private Integer revenueInDollars;
	private DirectorDTO director;
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public LocalDate getReleasedIn() {
		return releasedIn;
	}
	public void setReleasedIn(LocalDate releasedIn) {
		this.releasedIn = releasedIn;
	}
	public Integer getRevenueInDollars() {
		return revenueInDollars;
	}
	public void setRevenueInDollars(Integer revenueInDollars) {
		this.revenueInDollars = revenueInDollars;
	}
	public DirectorDTO getDirector() {
		return director;
	}
	public void setDirector(DirectorDTO director) {
		this.director = director;
	}

	@Override
	public String toString() {
		return "MovieDTO{" +
				"movieId='" + movieId + '\'' +
				", movieName='" + movieName + '\'' +
				", language='" + language + '\'' +
				", releasedIn=" + releasedIn +
				", revenueInDollars=" + revenueInDollars +
				", director=" + director +
				'}';
	}
}