package com.sujal.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import com.sujal.dto.MovieDTO;
import com.sujal.entity.Movie;
import com.sujal.exception.sujalMovieException;

@Repository(value="movieRepository")
public class MovieRepositoryImpl implements MovieRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public MovieDTO getMovieByName(String movieName) throws sujalMovieException {
		Query query = entityManager.createQuery("Select m from Movie m where m.movieName=?1");
		query.setParameter(1, movieName);
		Movie m = (Movie) query.getSingleResult();
		if(m==null) throw new sujalMovieException("Service.NO_MOVIE_FOUND");
		MovieDTO movieDTO = new MovieDTO();
		movieDTO.setDirectorName(m.getDirectorName());
		movieDTO.setImdbRating(m.getImdbRating());
		movieDTO.setMovieId(m.getMovieId());
		movieDTO.setMovieName(m.getMovieName());
		movieDTO.setYear(m.getYear());
		return movieDTO;
	}

	@Override
	public List<MovieDTO> getMoviesByImdbRating(Double fromRating, Double toRating) throws sujalMovieException{
		Query query = entityManager.createQuery("Select m from Movie m where m.imdbRating between :fromRating and :toRating");
		query.setParameter("fromRating", fromRating);
		query.setParameter("toRating", toRating);
		
		List<Movie> list =  query.getResultList();
		if(list.isEmpty()) throw new sujalMovieException("Service.NO_MOVIES_FOUND_FOR_RATING");
		
		List<MovieDTO> movieDTOs = list.stream().map(t->new MovieDTO(t.getMovieId(), t.getMovieName(), t.getDirectorName(), t.getImdbRating(), t.getYear())).toList();
		return movieDTOs;
	}

	@Override
	public List<Object[]> getMoviesNameAndYear(String directorName) throws sujalMovieException {
		Query query = entityManager.createQuery("Select m.movieName,m.year from Movie m where m.directorName=:directorName");
		query.setParameter("directorName", directorName);
		List<Object[]> list =  query.getResultList();
		if(list.isEmpty()) {
			throw new sujalMovieException("Service.MOVIE_NOT_FOUND_FOR_DIRECTOR");
		}
		return list;
	}

	

}
