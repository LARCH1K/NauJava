package ru.nikita.naujava.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.nikita.naujava.entities.Lesson;
import ru.nikita.naujava.repositories.LessonRepository;

import java.util.List;

@RestController
@RequestMapping("/lesson/custom")
public class LessonController {

    private final LessonRepository lessonRepository;

    public LessonController(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @GetMapping("/getLessonsByTeacherName")
    public List<Lesson> getLessonsByTeacherName(@RequestParam String teacher) {
        return lessonRepository.getLessonsByTeacherName(teacher);
    }
}
