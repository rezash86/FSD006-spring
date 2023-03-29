package com.jac.mvcproject.joinexamples.one_to_one;

import com.jac.mvcproject.joinexamples.one_to_one.model.User;
import com.jac.mvcproject.joinexamples.one_to_one.model.UserProfile;
import com.jac.mvcproject.joinexamples.one_to_one.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private final UserRepository userRepository;

    @Autowired
    public DemoApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        var user = User
                .builder()
                .email("r.s@gmail.com")
                .firstName("Reza")
                .lastName("shal")
                .userProfile(UserProfile.builder().address("Montreal").phoneNumber("438438438").build())
                .build();

        userRepository.save(user);
    }
}
