package ru.nikita.naujava.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "day_schedule")
public class DaySchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "day_id")
    private Long id;

    @Column
    private LocalDate dateOfDay;

    @Column
    private Integer countOfLessons;

    @Column
    private String nameOfDay;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private WeekSchedule weekSchedule;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateOfDay() {
        return dateOfDay;
    }

    public void setDateOfDay(LocalDate dateOfDay) {
        this.dateOfDay = dateOfDay;
    }

    public Integer getCountOfLessons() {
        return countOfLessons;
    }

    public void setCountOfLessons(Integer countOfLessons) {
        this.countOfLessons = countOfLessons;
    }

    public String getNameOfDay() {
        return nameOfDay;
    }

    public void setNameOfDay(String nameOfDay) {
        this.nameOfDay = nameOfDay;
    }

    public WeekSchedule getWeekSchedule() {
        return weekSchedule;
    }

    public void setWeekSchedule(WeekSchedule weekSchedule) {
        this.weekSchedule = weekSchedule;
    }
}