package ru.nikita.naujava.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.nikita.naujava.entities.DaySchedule;

public interface DayScheduleRepository extends CrudRepository<DaySchedule, Long> {
}
