package ru.nikita.naujava.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
        return homeworkRepository.getHomeworksByMarkBetween(min, max);
    }

    @GetMapping("/getHomeworksWithMarkMoreThanThree")
    public List<Homework> getHomeworksWithMarkMoreThanThree() {
        return homeworkRepository.getHomeworksWithMarkMoreThanThree();
    }


}

