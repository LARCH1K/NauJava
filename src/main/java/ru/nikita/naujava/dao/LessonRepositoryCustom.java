package ru.nikita.naujava.dao;

import ru.nikita.naujava.entities.Lesson;

import java.util.List;

public interface LessonRepositoryCustom {

    List<Lesson> getLessonsWhereMarkInHomeworkMoreThanThree();
}
