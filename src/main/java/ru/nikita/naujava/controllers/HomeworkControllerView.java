package ru.nikita.naujava.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.nikita.naujava.entities.Homework;
import ru.nikita.naujava.repositories.HomeworkRepository;

@Controller
@RequestMapping("/homework/view")
public class HomeworkControllerView {

    private final HomeworkRepository homeworkRepository;

    @Autowired
    public HomeworkControllerView(HomeworkRepository homeworkRepository) {
        this.homeworkRepository = homeworkRepository;
    }

    @GetMapping("/list")
    public String homeworkListView(Model model) {
        Iterable<Homework> homeworks = homeworkRepository.findAll();
        model.addAttribute("Homeworks", homeworks);
        return "homeworkList";
    }
}
