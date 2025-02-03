package com.sujal.dto;

public class MovieDTO {

	public MovieDTO(Integer movieId, String movieName, String directorName, Float imdbRating, Integer year) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.directorName = directorName;
		this.imdbRating = imdbRating;
		this.year = year;
	}

	private Integer movieId;
	private String movieName;
	private String directorName;
	private Float imdbRating;
	private Integer year;

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public Float getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(Float imdbRating) {
		this.imdbRating = imdbRating;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "MovieDTO [movieId=" + movieId + ", movieName=" + movieName + ", directorName=" + directorName
				+ ", imdbRating=" + imdbRating + ", year=" + year + "]";
	}
}
