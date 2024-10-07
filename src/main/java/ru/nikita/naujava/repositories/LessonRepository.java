package ru.nikita.naujava.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.nikita.naujava.entities.Lesson;

import java.util.List;

public interface LessonRepository extends CrudRepository<Lesson, Long> {
    List<Lesson> getLessonsByTeacherName(String teacher);
}
