package com.sujal.service;

import java.util.List;

import com.sujal.dto.MovieDTO;
import com.sujal.exception.sujalMovieException;

public interface MovieService {

	public List<MovieDTO> getMovieByRating(Double fromRating) throws sujalMovieException;

	public List<MovieDTO> getHighestRatedMovie(String directorName) throws sujalMovieException;

	public Float getAverageDirectorRating(String directorName) throws sujalMovieException;

	public Long getNumberOfMoviesReleased(Integer fromYear, Integer toYear) throws sujalMovieException;
}
