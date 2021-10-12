package org.arpit.java2blog;

import java.util.List;

import org.arpit.java2blog.model.InData;
import org.arpit.java2blog.model.Movie;
import org.arpit.java2blog.model.RelatedParty;
import org.arpit.java2blog.model.Root;
import org.arpit.java2blog.repository.MovieRepository;
import org.arpit.java2blog.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@SpringBootApplication
public class SpringBootH2ExampleApplication implements CommandLineRunner {

	@Autowired
    MovieService movieService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootH2ExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Movie mvoie = new Movie();
		mvoie.setName("{\n" + 
				"  \"relatedParty\": [\n" + 
				"    {\n" + 
				"      \"Name\": \"John\",\n" + 
				"      \"age\": 23\n" + 
				"    }\n" + 
				"  ]\n" + 
				"}");
		mvoie.setGenre("M");
		movieService.saveOrUpdate(mvoie);
		

		
		System.out.println(movieService.getAllMovies().toString());
		
		

		List<Movie> mvo = movieService.getAllMovies();
		
		
		ObjectMapper om = new ObjectMapper();
		Root in = om.readValue(mvo.get(0).getName(), Root.class);
		
		if (in!= null) {
			List<RelatedParty> i =in.relatedParty;
			System.out.println(i.get(0).getName());
			mvoie.setName(i.get(0).getName());
			mvoie.setGenre("M");
			mvoie.setId(5);
		}
		
		movieService.saveOrUpdate(mvoie);
		
	}

}
