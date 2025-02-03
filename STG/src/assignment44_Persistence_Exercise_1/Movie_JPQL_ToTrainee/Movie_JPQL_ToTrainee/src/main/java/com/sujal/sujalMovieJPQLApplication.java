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
public class sujalMovieJPQLApplication implements CommandLineRunner {

	private static final Logger LOGGER = LogManager.getLogger(sujalMovieJPQLApplication.class);

	@Autowired
	private MovieService movieService;

	@Autowired
	private Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(sujalMovieJPQLApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		getMovieByName();
		getMovieByImdbRating();
		getMoviesNameAndYear();
	}

	public void getMovieByName() {

		try {
			String movieName = "Deadpool";
			MovieDTO movieDTO = movieService.getMovieByName(movieName);
			LOGGER.info(movieDTO);
			LOGGER.info("\n");
		} catch (Exception e) {
			LOGGER.info(environment.getProperty(e.getMessage(), "Some exception occured.Please check log file."));
			LOGGER.info("\n");
		}
	}

	public void getMovieByImdbRating() {
		try {
			Double fromRating = 0.0d;
			Double toRating = 7.8d;
			List<MovieDTO> movieDTOs = movieService.getMoviesByImdbRating(fromRating, toRating);
			for (MovieDTO movieDTO : movieDTOs) {
				LOGGER.info(movieDTO);		
			}
			LOGGER.info("\n");
		} catch (Exception e) {
			LOGGER.info(environment.getProperty(e.getMessage(), "Some exception occured.Please check log file."));
			LOGGER.info("\n");
		}
	}

	public void getMoviesNameAndYear() {

		try {
			String directorName = "Joss Whedon";
			List<Object[]> objects = movieService.getMoviesNameAndYear(directorName);
			for (Object[] object : objects) {
				LOGGER.info(object[0] + "\t" + object[1]);
			}
			LOGGER.info("\n");
		} catch (Exception e) {
			LOGGER.info(environment.getProperty(e.getMessage(), "Some exception occured.Please check log file."));
			LOGGER.info("\n");
		}
	}
}
