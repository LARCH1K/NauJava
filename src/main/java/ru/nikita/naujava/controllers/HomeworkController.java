package ru.nikita.naujava.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;
import ru.nikita.naujava.entities.Homework;
import ru.nikita.naujava.repositories.HomeworkRepository;

import java.util.List;

@RestController
@RequestMapping("/homework/custom")
public class HomeworkController {

    private final HomeworkRepository homeworkRepository;

    @Autowired
    public HomeworkController(HomeworkRepository homeworkRepository) {
        this.homeworkRepository = homeworkRepository;
    }

    @GetMapping("/getHomeworksByMarkBetween")
    public List<Homework> getHomeworksByMarkBetween(@RequestParam Integer min, @RequestParam Integer max) {
        List<Homework> homeworks = homeworkRepository.getHomeworksByMarkBetween(min, max);
        if(homeworks.isEmpty()) {
            throw new ResourceNotFoundException("No homeworks found between " + min + " and " + max);
        }
        return homeworks;
    }

    @GetMapping("/getHomeworksWithMarkMoreThanThree")
    public List<Homework> getHomeworksWithMarkMoreThanThree() {
        List<Homework> homeworks = homeworkRepository.getHomeworksWithMarkMoreThanThree();
        if(homeworks.isEmpty()) {
            throw new ResourceNotFoundException("No homeworks found with mark more than 3");
        }
        return homeworks;
    }


}

