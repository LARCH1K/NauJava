package ru.nikita.naujava.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "week_schedule")
public class WeekSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Long id;

    @Column
    private Integer numberOfWeek;

    @Column
    private LocalDate startDate;

    @Column
    private LocalDate finishDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumberOfWeek() {
        return numberOfWeek;
    }

    public void setNumberOfWeek(Integer numberOfWeek) {
        this.numberOfWeek = numberOfWeek;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }

}