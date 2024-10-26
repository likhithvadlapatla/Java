package com.ge.repository;

import com.ge.model.Task;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ITaskRepo extends JpaRepository<Task, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Task t SET t.id=:#{#task.id}," +
            "t.title=:#{#task.title}," +
            "t.description=:#{#task.description}," +
            "t.priority=:#{task.priority}," +
            "t.status=:#{task.status}," +
            "t.dueDate=:#{#task.dueDate}," +
            "t.isOverdue=:#{#task.isOverdue}"
    )
    public void updateTask(Task task);

    @Transactional
    @Modifying
    @Query("DELETE FROM Task t WHERE t.id=:taskId")
    public void deleteTask(Long taskId);

    Task findTaskById(Long taskId);

    List<Task> findTaskByUser_id(Long userId);

    List<Task> findTaskByCategory_id(Long categoryId);

    List<Task> findTaskByPriority(String priority);

    List<Task> findTaskByStatus(String status);

//    @Query("SELECT t FROM Task t WHERE t.dueDate BETWEEN CURRENT_DATE AND CURRENT_DATE + 7")
//    List<Task> findTaskDueSoon();

    @Query("SELECT t FROM Task t WHERE t.isOverdue=true")
    List<Task> findOverdueTask();

//    @Query("SELECT t " +
//            "FROM Task t " +
//            "WHERE LOWER(t.title) LIKE LOWER(CONCAT('%',:keyword,'%')) " +
//            "OR LOWER(t.description) LIKE LOWER(CONCAT('%',:keyword,'%')) " +
//            "OR LOWER(t.comments) LIKE LOWER(CONCAT('%',:keyword,'%'))")
//    List<Task> searchTask(String keyword);

    @Query("SELECT t FROM Task t WHERE t.dueDate BETWEEN :startDate AND :endDate")
    List<Task> findTaskByDueDateRange(String startDate, String endDate);
}
