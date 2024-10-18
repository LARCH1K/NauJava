package ru.nikita.naujava.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.nikita.naujava.entities.Lesson;

import java.util.List;

public interface LessonRepository extends CrudRepository<Lesson, Long> {
    List<Lesson> getLessonsByTeacherName(String teacher);

    @Query("FROM Lesson l JOIN l.homework h WHERE h.mark > 3")
    List<Lesson> getLessonsWhereMarkInHomeworkMoreThanThree();
}
