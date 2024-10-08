package ru.nikita.naujava.dao;

import ru.nikita.naujava.entities.Homework;

import java.util.List;

public interface HomeworkRepositoryCustom {

    List<Homework> getHomeworksByMarkBetween(Integer min, Integer max);

    List<Homework> getHomeworksWithMarkMoreThanThree();
}
