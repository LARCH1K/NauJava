package ru.nikita.naujava.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.nikita.naujava.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
