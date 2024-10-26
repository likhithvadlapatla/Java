package com.ge.service;

import com.ge.dto.NotificationRequest;
import com.ge.model.Category;
import com.ge.model.Task;
import com.ge.model.User;
import com.ge.repository.ITaskRepo;
import com.ge.repository.IUserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements ITaskService{

    @Autowired
    private ITaskRepo repo1;

    @Autowired
    private IUserRepo repo2;

    private static final Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);

        /*
        Object-Oriented Approach:
        JPA is built around the idea of mapping objects, not just raw database values. When you work with objects like User and Category, you're leveraging the power of the ORM to manage relationships, states, and interactions between entities.
        By passing full objects, you're ensuring that these relationships are strongly typed and consistent. You avoid the risk of passing incorrect IDs that could break relational integrity.

        Lazy Loading and Proxies:
        When you fetch entities like User and Category, JPA may use lazy loading or proxies, only fetching related data when it's needed. If you just use IDs, you would lose the flexibility of ORM and the automatic fetching of related data when necessary.
        If only IDs were used, additional manual queries might be required to fetch the actual objects if needed later, which would defeat the purpose of ORM.

        Referential Integrity and Validation:
        By fetching the User and Category objects, you can validate that the objects exist in the database before assigning them to the Task. This ensures that you're not creating relationships with invalid or non-existent entities.
        If you only work with IDs, you could accidentally assign invalid IDs, leading to database errors (e.g., foreign key constraint violations).

        Cascading and Entity Lifecycle:
        When dealing with related entities, cascading is a powerful feature in JPA. If you're passing full objects, you can configure JPA to automatically handle certain operations (e.g., saving, updating, deleting) on related entities without explicitly writing extra code.
        Passing only IDs bypasses these lifecycle management benefits, requiring you to manually handle the associations and persistence.

        Cascading refers to the automatic propagation of operations from a parent entity to its related child entities. It allows you to perform certain operations like persist, merge, remove, etc.,
    */

    @Override
    public Task createTask(Long id, String title, String description, User user, Category category, String priority, String status, LocalDate dueDate, boolean isOverdue) {
        Task task = new Task();
        task.setId(id);
        task.setTitle(title);
        task.setDescription(description);
        task.setUser(user);
        task.setCategory(category);
        task.setPriority(priority);
        task.setStatus(status);
        task.setDueDate(dueDate);
        task.setOverdue(isOverdue);
        task.setCreatedAt(LocalDateTime.now());
        task.setUpdatedAt(LocalDateTime.now());
        task.setComments(new ArrayList<>());
        try{
            Task savedTask = repo1.save(task);;
            logger.info("Task created successfully with ID: {}", savedTask.getId());
            return savedTask;
        }
        catch(Exception e){
            logger.error("Error occurred while creating task: {]", e.getMessage());
            throw e;
        }
    }

    @Override
    public void updateTask(Task task) {
        logger.info("Updating task with ID: {}",task.getId());
        try{
            repo1.updateTask(task);
            logger.info("Task updated successfully with ID: {}",task.getId());
        }
        catch(Exception e){
            logger.error("Error occurred while updating task: {}",task.getId());
            throw e;
        }
    }

    @Override
    public void deleteTask(Long taskId) {
        logger.info("Deleting task with ID: {}",taskId);
        try{
            repo1.deleteTask(taskId);
            logger.info("Task deleted successfully with ID: {}",taskId);
        }
        catch(Exception e){
            logger.error("Error occurred while deleting task: {}",taskId);
            throw e;
        }
    }

    @Override
    public Task findTaskById(Long taskId) {
        return repo1.findTaskById(taskId);
    }

    @Override
    public List<Task> findAllTasks() {
        return repo1.findAll();
    }

    @Override
    public List<Task> findTaskByUser_id(Long userId) {
        return repo1.findTaskByUser_id(userId);
    }

    @Override
    public List<Task> findTaskByCategory_id(Long categoryId) {
        return repo1.findTaskByCategory_id(categoryId);
    }

    @Override
    public List<Task> findTaskByPriority(String priority) {
        return repo1.findTaskByPriority(priority);
    }

    @Override
    public List<Task> findTaskByStatus(String status) {
        return repo1.findTaskByStatus(status);
    }

//    @Override
//    public List<Task> findTasksDueSoon() {
//        return repo1.findTaskDueSoon();
//    }

    @Override
    public List<Task> findOverdueTask() {
        return repo1.findOverdueTask();
    }

//    @Override
//    public List<Task> searchTask(String keyword) {
//        return repo1.searchTask(keyword);
//    }

    @Override
    public void assignTaskToUser(Long taskId, Long userId) {
        Task task = repo1.findTaskById(taskId);
        task.setUser(repo2.findUserById(userId));
        repo1.save(task);
    }

    @Override
    public void changeTaskStatus(Long taskId, String status) {
        Task task = repo1.findTaskById(taskId);
        task.setStatus(status);
        repo1.save(task);
    }

    @Override
    public void prioritizeTask(Long taskId, String priority) {
        Task task = repo1.findTaskById(taskId);
        task.setPriority(priority);
        repo1.save(task);
    }

    @Override
    public List<Task> findTaskByDueDateRange(String startDate, String endDate) {
        return repo1.findTaskByDueDateRange(startDate,endDate);
    }


    private String notification_url = "http://localhost:8088/sendNotification";

    public void sendCustomerNotification(Long userId, String message) {
        String email = repo2.findUserById(userId).getEmail();
        NotificationRequest notificationRequest = new NotificationRequest(userId,message,email);
        WebClient webClient = WebClient.create();
        webClient.post()
                .uri(notification_url)
                .bodyValue(notificationRequest)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }


}
