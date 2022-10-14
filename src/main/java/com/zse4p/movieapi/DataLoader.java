package com.zse4p.movieapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.zse4p.movieapi.models.Movie;
import com.zse4p.movieapi.models.User;
import com.zse4p.movieapi.repositories.MovieRepo;
import com.zse4p.movieapi.repositories.UserRepo;

@Component
public class DataLoader implements CommandLineRunner {


	@Autowired
	private MovieRepo movieRepo;

	@Autowired
	private UserRepo userRepo;

    @Override
    public void run(String... args) throws Exception {
        
        movieRepo.save(new Movie("Gayniggers From Outer Space", 1992, "Robert Lewandowski"));
        movieRepo.save(new Movie("Marta mowi", 2008, "Jan Pawel Drugi"));
    
        userRepo.save(new User("user", "pass", UserRole.User));
        userRepo.save(new User("critic", "pass", UserRole.Critic));
        userRepo.save(new User("moderator", "pass", UserRole.Moderator));
    
    }
    
}
