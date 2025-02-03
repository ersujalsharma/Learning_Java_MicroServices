package com.sujal.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import com.sujal.dto.MovieDTO;
import com.sujal.entity.Movie;

@Repository(value="movieRepository")
public class MovieRepositoryImpl implements MovieRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<MovieDTO> getMovieByRating(Double fromRating) {
		Query query = entityManager.createQuery("Select m from Movie m where m.imdbRating >= :fromRating");
		query.setParameter("fromRating", fromRating);
		List<Movie> movies = query.getResultList();
		if(movies == null) return new ArrayList<>();
		List<MovieDTO> movieDTOs = movies.stream().map(t->new MovieDTO(t.getMovieId(), t.getMovieName(), t.getDirectorNme(), t.getImdbRating(), t.getYear())).toList();
		return movieDTOs;
	}

	@Override
	public List<MovieDTO> getHighestRatedMovie(String directorName) {
		Query query = entityManager.createQuery(
		        "SELECT m FROM Movie m WHERE m.imdbRating = " +
		        "(SELECT MAX(m2.imdbRating) FROM Movie m2 WHERE m2.directorName = :directorName) " +
		        "AND m.directorName = :directorName", Movie.class);
		query.setParameter("directorName", directorName);
		List<Movie> movies = query.getResultList();
		List<MovieDTO> movieDTOs = movies.stream().map(t->new MovieDTO(t.getMovieId(), t.getMovieName(), t.getDirectorNme(), t.getImdbRating(), t.getYear())).toList();
		return movieDTOs;
	}

	@Override
	public Float getAverageDirectorRating(String directorName) {
		Query avgRatingQuery = entityManager.createQuery(
	            "SELECT AVG(m.imdbRating) FROM Movie m WHERE m.directorName = :directorName", Float.class);
	        avgRatingQuery.setParameter("directorName", directorName);
	        Float averageRating =((Double)avgRatingQuery.getSingleResult()).floatValue();
	        if (averageRating == null) {
	            return null;
	        }
	        return averageRating;
	}

	@Override
	public Long getNumberOfMoviesReleased(Integer fromYear, Integer toYear) {
		Query query = entityManager.createQuery("select count(m.movieId) from Movie m where m.year between :fromYear and :toYear");
		query.setParameter("fromYear", fromYear);
		query.setParameter("toYear", toYear);
		Long longedValue = ((Long) query.getSingleResult());
		return longedValue;
	}

	

}
