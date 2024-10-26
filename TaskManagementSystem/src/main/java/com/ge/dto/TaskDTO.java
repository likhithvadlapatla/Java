package com.ge.dto;

import java.time.LocalDate;

public class TaskDTO {
    private Long id;
    private String title;
    private String description;
    private Long userId;
    private Long categoryId;
    private String priority;
    private String status;
    private LocalDate dueDate;
    private boolean isOverdue;

    public TaskDTO(Long id, String title, String description, Long userId, Long categoryId, String priority, String status, LocalDate dueDate, boolean isOverdue) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.userId = userId;
        this.categoryId = categoryId;
        this.priority = priority;
        this.status = status;
        this.dueDate = dueDate;
        this.isOverdue = isOverdue;
    }

    public TaskDTO() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean getIsOverdue() {
        return isOverdue;
    }

    public void setIsOverdue(boolean isOverdue) {
        this.isOverdue = isOverdue;
    }

    @Override
    public String toString() {
        return "TaskDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", userId=" + userId +
                ", categoryId=" + categoryId +
                ", priority='" + priority + '\'' +
                ", status='" + status + '\'' +
                ", dueDate=" + dueDate +
                ", isOverdue='" + isOverdue + '\'' +
                '}';
    }
}
