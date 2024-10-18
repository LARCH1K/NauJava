package ru.nikita.naujava.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.nikita.naujava.entities.Student;

@RepositoryRestResource(path = "students")
public interface StudentRepository extends CrudRepository<Student, Long> {
}
