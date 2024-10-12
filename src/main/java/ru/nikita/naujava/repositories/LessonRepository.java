package ru.nikita.naujava.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.nikita.naujava.entities.Lesson;

import java.util.List;

@RepositoryRestResource(path = "lessons")
public interface LessonRepository extends CrudRepository<Lesson, Long> {
    List<Lesson> getLessonsByTeacherName(String teacher);
}
