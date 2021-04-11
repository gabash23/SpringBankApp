package com.example.demo.currency;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CoinConfig {

    @Bean
    CommandLineRunner commandLineRunner(HolderRepository repository) {
        return args -> {
            Holder gab = new Holder(
                    1L,
                    2000,
                    "Gab",
                    "gabiscool",
                    "poggers"
            );

            Holder mcqueen = new Holder(
                    1000,
                    "McQueen",
                    "Lightning",
                    "cars1goodmovie"
            );

            repository.saveAll(
                    List.of(gab, mcqueen)
            );
        };
    }

}
