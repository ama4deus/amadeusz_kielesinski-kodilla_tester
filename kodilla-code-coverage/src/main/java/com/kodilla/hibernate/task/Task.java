package com.kodilla.hibernate.task;

// Ważny import, aby klasa Task "widziała" TaskList z drugiego pakietu!
import com.kodilla.hibernate.tasklist.TaskList;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "TASKS")
public class Task {
    // 1. POLA KLASY
    private int id;
    private String description;
    private LocalDate created;
    private int duration;
    private TaskFinancialDetails taskFinancialDetails;
    private TaskList taskList; // <--- NOWE POLE RELACJI 1:N

    // 2. KONSTRUKTORY
    public Task() {
    }

    public Task(String description, int duration) {
        this.description = description;
        this.created = LocalDate.now();
        this.duration = duration;
    }

    // 3. GETTERY I SETTERY
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    @NotNull
    @Column(name = "CREATED")
    public LocalDate getCreated() {
        return created;
    }

    private void setCreated(LocalDate created) {
        this.created = created;
    }

    @Column(name = "DURATION")
    public int getDuration() {
        return duration;
    }

    private void setDuration(int duration) {
        this.duration = duration;
    }

    // Relacja OneToOne (Do szczegółów finansowych)
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "TASKS_FINANCIALS_ID")
    public TaskFinancialDetails getTaskFinancialDetails() {
        return taskFinancialDetails;
    }

    public void setTaskFinancialDetails(TaskFinancialDetails taskFinancialDetails) {
        this.taskFinancialDetails = taskFinancialDetails;
    }

    // Relacja ManyToOne (Wiele zadań do jednej listy - NOWOŚĆ)
    @ManyToOne
    @JoinColumn(name = "TASKLIST_ID")
    public TaskList getTaskList() {
        return taskList;
    }

    public void setTaskList(TaskList taskList) {
        this.taskList = taskList;
    }
}