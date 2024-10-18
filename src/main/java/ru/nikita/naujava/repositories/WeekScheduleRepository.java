package ru.nikita.naujava.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.nikita.naujava.entities.WeekSchedule;

@RepositoryRestResource(path = "weekSchedules")
public interface WeekScheduleRepository extends CrudRepository<WeekSchedule, Long> {
}
