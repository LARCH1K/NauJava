package ru.nikita.naujava.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.nikita.naujava.entities.Homework;

import java.util.List;

@Repository
public class HomeworkRepositoryCustomImpl implements HomeworkRepositoryCustom {

    private final EntityManager entityManager;

    @Autowired
    public HomeworkRepositoryCustomImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Homework> getHomeworksByMarkBetween(Integer min, Integer max) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Homework> criteriaQuery = criteriaBuilder.createQuery(Homework.class);

        Root<Homework> root = criteriaQuery.from(Homework.class);
        Predicate predicate = criteriaBuilder.between(root.get("mark"), min, max);
        criteriaQuery.select(root).where(predicate);

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public List<Homework> getHomeworksWithMarkMoreThanThree() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Homework> criteriaQuery = criteriaBuilder.createQuery(Homework.class);

        Root<Homework> root = criteriaQuery.from(Homework.class);
        Predicate predicate = criteriaBuilder.greaterThan(root.get("mark"), 3);
        criteriaQuery.select(root).where(predicate);

        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
