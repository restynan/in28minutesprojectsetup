package com.in28munites.jpa.jpain10steps.repositories;

import com.in28munites.jpa.jpain10steps.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserServiceCommandLineRunner implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
   private UserRepositoryEntity userRepositoryEntity;

    @Override
    public void run(String... args) throws Exception {
        User user =new User("jack","Enginner");
        long inseted= userRepositoryEntity.insert(user);
        logger.info("new user created"+user);

    }
}
