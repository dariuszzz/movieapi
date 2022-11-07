package com.zse4p.movieapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.zse4p.movieapi.models.Movie;
import com.zse4p.movieapi.models.User;
import com.zse4p.movieapi.repositories.MovieRepo;
import com.zse4p.movieapi.services.UserService;

@Component
public class DataLoader implements CommandLineRunner {


	@Autowired
	private MovieRepo movieRepo;

	@Autowired
	private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        
        movieRepo.save(new Movie("The Truman Show", 1998, "Robert Lewandowski", List.of(Genre.Horror)));
        movieRepo.save(new Movie("Marta mowi", 2008, "Jan Pawel Drugi", List.of(Genre.Animated)));
    
        userService.registerUser(new User("user", "pass", UserRole.User));
        userService.registerUser(new User("critic", "pass", UserRole.Critic));
        userService.registerUser(new User("moderator", "pass", UserRole.Moderator));
    
    }
    
}
