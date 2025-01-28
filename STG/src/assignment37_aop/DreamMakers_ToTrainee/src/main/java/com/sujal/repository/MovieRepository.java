package com.sujal.repository;

import java.util.List;

import com.sujal.dto.MovieDTO;
import com.sujal.exception.DreamMakersException;

public interface MovieRepository {

	public String addMovie(MovieDTO movie) throws DreamMakersException;
	
	public List<MovieDTO> getAllMovies() throws DreamMakersException;
}
