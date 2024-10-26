package com.ge.service;

import com.ge.model.Category;
import com.ge.model.Task;
import com.ge.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface ITaskService {
    Task createTask(Long id, String title, String description, User user, Category category, String priority, String status, LocalDate dueDate, boolean isOverdue);
    void updateTask(Task task);
    void deleteTask(Long taskId);
    Task findTaskById(Long taskId);
    List<Task> findAllTasks();
    List<Task> findTaskByUser_id(Long userId);
    List<Task> findTaskByCategory_id(Long categoryId);
    List<Task> findTaskByPriority(String priority);
    List<Task> findTaskByStatus(String status);
    //List<Task> findTasksDueSoon();
    List<Task> findOverdueTask();
    //List<Task> searchTask(String keyword);
    void assignTaskToUser(Long taskId, Long userId);
    void changeTaskStatus(Long taskId, String status);
    void prioritizeTask(Long taskId, String priority);
    List<Task> findTaskByDueDateRange(String startDate, String endDate);
    public void sendCustomerNotification(Long userId, String message);

}
