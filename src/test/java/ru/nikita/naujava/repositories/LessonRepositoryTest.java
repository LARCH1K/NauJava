package ru.nikita.naujava.repositories;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.nikita.naujava.entities.Homework;
import ru.nikita.naujava.entities.Lesson;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class LessonRepositoryTest {

    private final LessonRepository lessonRepository;

    private final HomeworkRepository homeworkRepository;

    @Autowired
    public LessonRepositoryTest(LessonRepository lessonRepository,
                                HomeworkRepository homeworkRepository) {
        this.lessonRepository = lessonRepository;
        this.homeworkRepository = homeworkRepository;
    }

    @BeforeEach
    void setUp() {
        lessonRepository.deleteAll();
        homeworkRepository.deleteAll();
        Homework homework = new Homework("Math Homework", 4, LocalDate.now());
        Homework homework2 = new Homework("Science Homework", 2, LocalDate.now());
        homeworkRepository.save(homework);
        homeworkRepository.save(homework2);
        lessonRepository.save(new Lesson("Math", LocalTime.now(), LocalTime.now(),
                "Math Teacher", null, homework));
        lessonRepository.save(new Lesson("Science", LocalTime.now(), LocalTime.now(),
                "Science Teacher", null, homework2));
    }

    @AfterEach
    void tearDown() {
        lessonRepository.deleteAll();
        homeworkRepository.deleteAll();
    }

    @Test
    void testGetLessonsWhereMarkInHomeworkMoreThanThree() {
        List<Lesson> lessons = lessonRepository.getLessonsWhereMarkInHomeworkMoreThanThree();

        assertThat(lessons).hasSize(1);
        assertThat(lessons).extracting(Lesson::getSubject)
                .contains("Math");
        assertThat(lessons).extracting(Lesson::getHomework)
                .extracting(Homework::getDescription)
                .contains("Math Homework");
    }
}
