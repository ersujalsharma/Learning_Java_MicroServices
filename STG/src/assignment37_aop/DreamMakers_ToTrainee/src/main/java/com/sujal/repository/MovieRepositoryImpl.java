package com.sujal.repository;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sujal.dto.DirectorDTO;
import com.sujal.dto.MovieDTO;
import com.sujal.exception.DreamMakersException;


@Repository(value = "movieDao")
public class MovieRepositoryImpl implements MovieRepository {

	public String addMovie(MovieDTO movieDTO) throws DreamMakersException {

		return movieDTO.getMovieId();

	}

	public List<MovieDTO> getAllMovies() throws DreamMakersException {

		List<MovieDTO> movieList = new ArrayList<MovieDTO>();

		MovieDTO movie = new MovieDTO();
		movie.setMovieId("M1002");
		movie.setMovieName("Baby's Day Out");
		movie.setLanguage("English");
		movie.setReleasedIn(LocalDate.of(1994, 07, 01));
		movie.setRevenueInDollars(16800000);
		DirectorDTO director = new DirectorDTO();
		director.setDirectorId("D102");
		director.setDirectorName("Patrick Read Johnson");
		director.setBornIn(1962);
		movie.setDirector(director);

		MovieDTO movie1 = new MovieDTO();
		movie1.setMovieId("M1004");
		movie1.setMovieName("Taare Zameen Par");
		movie1.setLanguage("Hindi");
		movie1.setReleasedIn(LocalDate.of(2007, 12, 21));
		movie1.setRevenueInDollars(13000000);
		DirectorDTO director1 = new DirectorDTO();
		director1.setDirectorId("D104");
		director1.setDirectorName("Aamir Khan");
		director1.setBornIn(1965);
		movie1.setDirector(director1);
		
		MovieDTO movie2 = new MovieDTO();
		movie2.setMovieId("M1006");
		movie2.setMovieName("The Terminator");
		movie2.setLanguage("English");
		movie2.setReleasedIn(LocalDate.of(1984, 10, 26));
		movie2.setRevenueInDollars(13000000);
		DirectorDTO director2 = new DirectorDTO();
		director2.setDirectorId("D106");
		director2.setDirectorName("James Cameron");
		director2.setBornIn(1954);
		movie2.setDirector(director2);
		
		movieList.add(movie);
		movieList.add(movie1);
		movieList.add(movie2);

		return movieList;

	}
}