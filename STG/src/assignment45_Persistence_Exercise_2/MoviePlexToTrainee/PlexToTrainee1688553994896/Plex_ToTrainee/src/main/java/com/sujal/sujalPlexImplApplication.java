package com.sujal;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import com.sujal.dto.MovieDTO;
import com.sujal.service.MovieService;

@SpringBootApplication
public class sujalPlexImplApplication implements CommandLineRunner {
	private static final Logger LOGGER = LogManager.getLogger(sujalPlexImplApplication.class);
	@Autowired
	private MovieService movieService;

	@Autowired
	private Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(sujalPlexImplApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		getMovieByRating();
		getHighestRatedMovie();
		getAverageDirectorRating();
		getNumberOfMoviesReleased();
	}

	private void getMovieByRating() {

		try {

			Double fromRating = 7.6d;
			List<MovieDTO> movieDTOs = movieService.getMovieByRating(fromRating);
			movieDTOs.forEach(LOGGER::info);
		} catch (Exception e) {
			LOGGER.info(environment.getProperty(e.getMessage(), "Some exception occured.Please check log file."));
		}
		LOGGER.info("\n");
	}

	private void getHighestRatedMovie() {

		try {
			String directorName = "Joss Whedon";
			List<MovieDTO> movieDTOs = movieService.getHighestRatedMovie(directorName);
			movieDTOs.forEach(LOGGER::info);

		} catch (Exception e) {
			LOGGER.info(environment.getProperty(e.getMessage(), "Some exception occured.Please check log file."));

		}
		LOGGER.info("\n");
	}

	public void getAverageDirectorRating() {
		try {
			String directorName = "Tim Miller";
			Float avgRating = movieService.getAverageDirectorRating(directorName);
			LOGGER.info(environment.getProperty("UserInterface.MOVIE_AVG_RATING") + directorName + ": " + avgRating);

		} catch (Exception e) {
			LOGGER.info(environment.getProperty(e.getMessage(), "Some exception occured.Please check log file."));
		}
		LOGGER.info("\n");
	}

	public void getNumberOfMoviesReleased() {

		try {
			Integer fromYear = 2012;
			Integer toYear = 2016;
			Long noOfMoviesReleased = movieService.getNumberOfMoviesReleased(fromYear, toYear);
			LOGGER.info(environment.getProperty("UserInterface.MOVIE_YEAR_BETWEEN") + fromYear
					+ " and " + toYear+ " = "+noOfMoviesReleased);
			LOGGER.info("\n");
		} catch (Exception e) {
			LOGGER.info(environment.getProperty(e.getMessage(), "Some exception occured.Please check log file."));
		}
		LOGGER.info("\n");
	}

}
