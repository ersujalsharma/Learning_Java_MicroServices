package com.sujal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sujal.dto.MovieDTO;
import com.sujal.exception.DreamMakersException;
import com.sujal.repository.MovieRepository;
import com.sujal.repository.MovieRepositoryImpl;
import com.sujal.validator.Validator;

@Service(value = "movieService")
public class MovieServiceImpl implements MovieService {
	@Autowired
	private MovieRepository movieRepository;

	public String addMovie(MovieDTO movieDTO) throws DreamMakersException {
		Validator.validate(movieDTO);
		String val = movieRepository.addMovie(movieDTO);
		return val;
	}

	public List<MovieDTO> getMovies(String directorName) throws DreamMakersException {
		List<MovieDTO> list = movieRepository.getAllMovies();
		list = list.stream().filter(movieDTO->movieDTO.getDirector().getDirectorName().equals(directorName)).toList();
		if(list.isEmpty()) throw new DreamMakersException("Service.MOVIE_NOT_FOUND");
		return list;	
	}
}
