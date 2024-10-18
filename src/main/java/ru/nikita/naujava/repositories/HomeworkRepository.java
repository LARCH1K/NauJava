package ru.nikita.naujava.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.nikita.naujava.entities.Homework;

import java.util.List;

@RepositoryRestResource(path = "homeworks")
public interface HomeworkRepository extends CrudRepository<Homework, Long> {

    List<Homework> getHomeworksByMarkBetween(Integer min, Integer max);

    @Query("FROM Homework WHERE mark > 3")
    List<Homework> getHomeworksWithMarkMoreThanThree();
}
