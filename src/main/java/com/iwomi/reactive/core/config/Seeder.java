package com.iwomi.reactive.core.config;

import com.iwomi.reactive.frameworks.UserRepository;
import com.iwomi.reactive.frameworks.data.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class Seeder {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository) {
        var saveUser = UserEntity.builder()
                        .name("Samuel")
                        .email("samuel@gmail.com").build();
        UserEntity user = userRepository.save(saveUser);

        return args -> {
            log.info("Preloading " + user);
        };
    }
}
