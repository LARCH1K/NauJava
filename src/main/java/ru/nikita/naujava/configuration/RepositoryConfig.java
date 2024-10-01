package ru.nikita.naujava.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.nikita.naujava.entities.Homework;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class RepositoryConfig {
    @Bean
    public List<Homework> homeworkContainer() {
        return new ArrayList<>();
    }
}
