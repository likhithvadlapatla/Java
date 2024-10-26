package com.ge.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Report {
    private String reportType;
    private List<Task> tasks;
    private LocalDateTime createdAt;
    private LocalDate startDate;
    private LocalDate endDate;

    public Report() {
        super();
    }

    public Report(String reportType, List<Task> tasks, LocalDateTime createdAt, LocalDate startDate, LocalDate endDate) {
        this.reportType = reportType;
        this.tasks = tasks;
        this.createdAt = createdAt;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Report{" +
                "reportType='" + reportType + '\'' +
                ", tasks=" + tasks +
                ", createdAt=" + createdAt +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
