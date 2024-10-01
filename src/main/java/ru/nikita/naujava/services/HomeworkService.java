package ru.nikita.naujava.services;

import ru.nikita.naujava.entities.Homework;

import java.util.List;

public interface HomeworkService {

    void createHomework(Long id, String subject, Integer mark);

    List<Homework> findAll();

    Homework findById(Long id);

    void deleteById(Long id);

    void updateMark(Long id, Integer mark);
}
