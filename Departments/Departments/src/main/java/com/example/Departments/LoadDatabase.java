package com.example.Departments;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Configuration indicates that the class has @Bean definition methods.
@Configuration
 class LoadDatabase{
    // Logger used to log messages for a specific system or application component
    //getLogger used find or create a logger
    private static final Logger log =LoggerFactory.getLogger(LoadDatabase.class);
    //JavaBean classes that encapsulate many objects into a single object (the bean). 
    //@Bean to specify that it returns a bean to be managed by Spring context.
    @Bean
    //CommandLineRunner to indicate that a bean should run when it is contained within a SpringApplication
    CommandLineRunner initDatabase(DepartmentRepository repository){
        return args ->{
            log.info("Preloading " + repository.save(new Department("CSE","Developing new products or solving practical computing problems")));
            log.info("Preloading "+repository.save(new Department("ECE","Researching, designing, developing, and testing electronic equipment used in various systems.")));
            
        };
    }

    // @Bean
    // CommandLineRunner initiDatabase(TeachersRepository repository){
    //     return args ->{
    //         log.info("Preloading " + repository.save(new Teachers("Shanthi","shanthi@gamil.com","8994455992", 1)));
    //         log.info("Preloading "+repository.save(new Teachers("Keerthi","keerthi@gmail.com","77889995600", 2)));
    //         log.info("Preloading " + repository.save(new Teachers("Nandhini","nandhini@gamil.com","8994456992", 1)));
    //     };
    // }
    // @Bean
    // CommandLineRunner initiaDatabase(StudentsRepository repository){
    //     return args ->{
    //         log.info("Preloading " + repository.save(new Students("Ram","Ram@gamil.com","8994455992")));
    //         log.info("Preloading "+repository.save(new Students("Ravi","Ravi@gmail.com","77889995600")));
    //     };
    // }
    
 }
