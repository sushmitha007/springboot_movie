package com.stackroute.movieservice;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class MovieServiceApplication{ //implements ApplicationListener<ContextRefreshedEvent>, CommandLineRunner {


//	private MovieRepository movieRepository;
//	@Autowired
//	public MovieServiceApplication(MovieRepository movieRepository) {
//		this.movieRepository = movieRepository;
//	}
//		@Override
//		public void run(String... args) throws Exception {
//			System.out.println("CommandLineRunner running in the UnsplashApplication class...");
//			movieRepository.save(new Movie(2,"Googly","www.googly.jpg",4,2013,"hrjceh"));
//		}
//		@Override
//
//		public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//		movieRepository.save(new Movie(0,"Nota","www.nota.jpg",4.8,2018,"hrjceh"));
//			movieRepository.save(new Movie(1,"Titanic","www.titanic.jpg",5.8,2018,"eheerfrf"));
//	}
	public static void main(String[] args) {
		SpringApplication.run(MovieServiceApplication.class, args);
	}
}
