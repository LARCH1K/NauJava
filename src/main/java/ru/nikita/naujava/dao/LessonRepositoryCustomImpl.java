package ru.nikita.naujava.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.nikita.naujava.entities.Homework;
import ru.nikita.naujava.entities.Lesson;

import java.util.List;

@Repository
public class LessonRepositoryCustomImpl implements LessonRepositoryCustom {

    private final EntityManager entityManager;

    @Autowired
    public LessonRepositoryCustomImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Lesson> getLessonsWhereMarkInHomeworkMoreThanThree() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Lesson> criteriaQuery = criteriaBuilder.createQuery(Lesson.class);

        Root<Lesson> root = criteriaQuery.from(Lesson.class);
        Join<Lesson, Homework> homeworkJoin = root.join("homework");
        Predicate predicate = criteriaBuilder.greaterThan(homeworkJoin.get("mark"), 3);
        criteriaQuery.select(root).where(predicate);

        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
