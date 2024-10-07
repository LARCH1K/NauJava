package ru.nikita.naujava.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "homework")
public class Homework {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "homework_id")
    private Long id;

    @Column
    private String description;

    @Column
    private Integer mark;

    @Column
    private LocalDate createdAt;

    public Homework(String description, Integer mark, LocalDate creationAt) {
        this.description = description;
        this.mark = mark;
        this.createdAt = creationAt;
    }

    public Homework() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreationAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Homework{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", mark=" + mark +
                ", creationAt=" + createdAt +
                '}';
    }
}