package ru.nikita.naujava.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.nikita.naujava.entities.DaySchedule;

@RepositoryRestResource(path = "daySchedules")
public interface DayScheduleRepository extends CrudRepository<DaySchedule, Long> {
}
