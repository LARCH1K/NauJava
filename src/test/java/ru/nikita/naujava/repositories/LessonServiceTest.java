package ru.nikita.naujava.repositories;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.nikita.naujava.entities.Homework;
import ru.nikita.naujava.entities.Lesson;
import ru.nikita.naujava.services.LessonServiceImpl;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
public class LessonServiceTest {

    private final LessonServiceImpl lessonService;

    private final LessonRepository lessonRepository;

    private final HomeworkRepository homeworkRepository;

    @Autowired
    public LessonServiceTest(LessonServiceImpl lessonService, LessonRepository lessonRepository,
                             HomeworkRepository homeworkRepository) {
        this.lessonService = lessonService;
        this.lessonRepository = lessonRepository;
        this.homeworkRepository = homeworkRepository;
    }

    @BeforeEach
    void setUp() {
        lessonRepository.deleteAll();
        homeworkRepository.deleteAll();
        Homework homework = new Homework("Math Homework", 4, LocalDate.now());
        homeworkRepository.save(homework);
        lessonRepository.save(new Lesson("Math", LocalTime.now(), LocalTime.now(),
                "Math Teacher", null, homework));
    }

    @AfterEach
    void tearDown() {
        lessonRepository.deleteAll();
        homeworkRepository.deleteAll();
    }

    @Test
    void deleteLessonWhereTeacherTest() {
        assertThat(lessonRepository.getLessonsByTeacherName("Math Teacher")).hasSize(1);
        assertThat(homeworkRepository.findAll()).hasSize(1);
        lessonService.deleteLessonWhereTeacher("Math Teacher");
        assertThat(lessonRepository.getLessonsByTeacherName("Math Teacher")).isEmpty();
        assertThat(homeworkRepository.findAll()).isEmpty();
    }

    @Test
    void deleteLessonWhereTeacherWithExceptionTest() {
        assertThat(lessonRepository.getLessonsByTeacherName("Math Teacher")).hasSize(1);
        assertThat(homeworkRepository.findAll()).hasSize(1);
        assertThatThrownBy(() -> lessonService.deleteLessonWhereTeacherWithException("Math Teacher", true)).
                isInstanceOf(Exception.class);
        assertThat(lessonRepository.getLessonsByTeacherName("Math Teacher")).hasSize(1);
        assertThat(homeworkRepository.findAll()).hasSize(1);
    }

    @Test
    void deleteLessonWhereTeacherWithoutExceptionTest() {
        assertThat(lessonRepository.getLessonsByTeacherName("Math Teacher")).hasSize(1);
        assertThat(homeworkRepository.findAll()).hasSize(1);
        assertDoesNotThrow(() -> lessonService.deleteLessonWhereTeacherWithException("Math Teacher", false));
        assertThat(lessonRepository.getLessonsByTeacherName("Math Teacher")).isEmpty();
        assertThat(homeworkRepository.findAll()).isEmpty();
    }
}
