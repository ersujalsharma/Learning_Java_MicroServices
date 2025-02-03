package com.sujal.repository;

import java.util.List;

import com.sujal.dto.MovieDTO;
import com.sujal.exception.sujalMovieException;

public interface MovieRepository {
	public MovieDTO getMovieByName(String movieName) throws sujalMovieException;
	
	public List<MovieDTO> getMoviesByImdbRating(Double fromRating, Double toRating) throws sujalMovieException;

	public List<Object[]> getMoviesNameAndYear(String directorName) throws sujalMovieException;	
}
