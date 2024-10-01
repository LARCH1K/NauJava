package ru.nikita.naujava.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.nikita.naujava.entities.Homework;

import java.util.List;

@Component
public class HomeworkRepository implements CrudRepository<Homework, Long> {

    private final List<Homework> homeworkContainer;

    @Autowired
    public HomeworkRepository(List<Homework> homeworkContainer) {
        this.homeworkContainer = homeworkContainer;
    }

    @Override
    public void create(Homework homework) {
        homeworkContainer.add(homework);
    }

    @Override
    public List<Homework> readAll() {
        return homeworkContainer;
    }

    @Override
    public Homework read(Long id) {
        for (Homework homework : homeworkContainer) {
            if (homework.getId().equals(id)) {
                return homework;
            }
        }
        return null;
    }

    @Override
    public void update(Homework homework) {
        for (int i = 0; i < homeworkContainer.size(); i++) {
            if (homeworkContainer.get(i).getId().equals(homework.getId())) {
                homeworkContainer.set(i, homework);
                return;
            }
        }
        homeworkContainer.add(homework);
    }

    @Override
    public void delete(Long id) {
        for (Homework homework : homeworkContainer) {
            if (homework.getId().equals(id)) {
                homeworkContainer.remove(homework);
                return;
            }
        }
    }
}
