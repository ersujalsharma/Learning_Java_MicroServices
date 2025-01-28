package com.sujal.service;

import java.util.List;

import com.sujal.dto.MovieDTO;
import com.sujal.exception.DreamMakersException;

public interface MovieService {
	public String addMovie(MovieDTO movie) throws DreamMakersException;

	public List<MovieDTO> getMovies(String directorName) throws DreamMakersException;
}
