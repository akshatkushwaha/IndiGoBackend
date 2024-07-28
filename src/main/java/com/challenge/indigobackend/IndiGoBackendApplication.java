package com.challenge.indigobackend;

import com.challenge.indigobackend.model.Users;
import com.challenge.indigobackend.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class IndiGoBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(IndiGoBackendApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(UserRepository repository) {
        return args -> {
            repository.save(new Users(
                    0L,
                    "admin",
                    "admin@indigo.com",
                    null,
                    "admin",
                    "admin"
            ));
        };
    }
}
