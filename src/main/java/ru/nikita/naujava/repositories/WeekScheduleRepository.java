package ru.nikita.naujava.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.nikita.naujava.entities.WeekSchedule;

public interface WeekScheduleRepository extends CrudRepository<WeekSchedule, Long> {
}
