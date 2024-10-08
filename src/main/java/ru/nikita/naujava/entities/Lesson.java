package ru.nikita.naujava.entities;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "lesson")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lesson_id")
    private Long id;

    @Column
    private String subject;

    @Column
    private LocalTime startTime;

    @Column
    private LocalTime endTime;

    @Column
    private String teacherName;

    @ManyToOne
    @JoinColumn(name = "day_id")
    private DaySchedule daySchedule;

    @OneToOne
    @JoinColumn(name = "homework_id")
    private Homework homework;

    public Lesson() {
    }

    public Lesson(String subject, LocalTime startTime, LocalTime endTime, String teacherName,
                  DaySchedule daySchedule, Homework homework) {
        this.subject = subject;
        this.startTime = startTime;
        this.endTime = endTime;
        this.teacherName = teacherName;
        this.daySchedule = daySchedule;
        this.homework = homework;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Homework getHomework() {
        return homework;
    }

    public void setHomework(Homework homework) {
        this.homework = homework;
    }

    public DaySchedule getDaySchedule() {
        return daySchedule;
    }

    public void setDaySchedule(DaySchedule daySchedule) {
        this.daySchedule = daySchedule;
    }
}