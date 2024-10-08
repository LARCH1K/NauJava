package ru.nikita.naujava.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.nikita.naujava.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
