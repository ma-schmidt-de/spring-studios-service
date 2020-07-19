package com.mschmidt.sss;

import com.mschmidt.sss.entity.Studio;
import com.mschmidt.sss.repository.StudioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudioServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudioServiceApplication.class);
    }

    @Bean
    public CommandLineRunner sampleData(StudioRepository repository) {
        return (args) -> {
            repository.save(new Studio("DRS Office", "Dresden - A place to be", "Germany", 15));
            repository.save(new Studio("BCN Office", "Barcelona - Sunshine all year", "Spain", 150));
            repository.save(new Studio("LDN Office", "London - My cup of tea", "England", 35));
        };
    }
}
