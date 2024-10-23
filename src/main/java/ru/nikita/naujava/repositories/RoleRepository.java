package ru.nikita.naujava.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.nikita.naujava.entities.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
}
