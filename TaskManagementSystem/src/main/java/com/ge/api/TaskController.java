package com.ge.api;

import com.ge.dto.NotificationRequest;
import com.ge.dto.TaskDTO;
import com.ge.model.Category;
import com.ge.model.Task;
import com.ge.model.User;
import com.ge.repository.ICategoryRepo;
import com.ge.repository.IUserRepo;
import com.ge.service.ITaskService;
import com.sun.nio.sctp.Notification;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/task")
@Tag(name = "Task Controller API's", description = "API's related to task.")
public class TaskController {

    @Autowired
    private ITaskService service;

    @Autowired
    private IUserRepo repo1;

    @Autowired
    private ICategoryRepo repo2;

    /*
        Logging should be used selectively, not in every method, but only in places where it adds the most value. The goal is to balance meaningful logging without overloading the system with unnecessary log statements.

        When to Add Logging:
        Critical Business Logic: Add logging to methods that perform essential operations (e.g., createTask, updateTask, deleteTask).
        Error Handling: Log when exceptions occur to capture useful diagnostic information (e.g., inside the catch block).
        External Interactions: If you're calling external systems (databases, services), log the interaction details.
        Input/Output of Key Methods: Log the input and output of methods responsible for crucial data transformations (e.g., createTask and updateTask).

        When to Avoid Logging:
        Simple Getters: If a method is just returning data without much logic (e.g., findAllTasks, findTaskByStatus), logging may be unnecessary.
        Unchanged Logic: Methods that call other methods without adding new functionality might not need logs.
     */

    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    @PostMapping("/createTask")
    @Operation(summary = "POST Operation", description = "API will accept json task info and return task object.")
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO taskDTO){
        logger.info("Received request to create task : {}", taskDTO);
        try {
                User user = repo1.findUserById(taskDTO.getUserId());
                Category category = repo2.findCategoryById(taskDTO.getCategoryId());

                if (user == null || category == null) {
                    logger.warn("Invalid user or category for creation: userId={}, categoryId={}",taskDTO.getUserId(),taskDTO.getCategoryId());
                    return ResponseEntity.badRequest().build();
                }

                Task task = service.createTask(
                        taskDTO.getId(),
                        taskDTO.getTitle(),
                        taskDTO.getDescription(),
                        user,
                        category,
                        taskDTO.getPriority(),
                        taskDTO.getStatus(),
                        taskDTO.getDueDate(),
                        taskDTO.getIsOverdue()
                );

                TaskDTO responseDTO = new TaskDTO(
                        task.getId(),
                        task.getTitle(),
                        task.getDescription(),
                        task.getUser().getId(),
                        task.getCategory().getId(),
                        task.getPriority(),
                        task.getStatus(),
                        task.getDueDate(),
                        task.isOverdue()
                );
                return ResponseEntity.ok(responseDTO);
        }
        catch(Exception e){
            logger.error("Error occurred while creating task: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/updateTask")
    @Operation(summary = "Put Operation",description = "API will accept json task info and it will update.")
    public ResponseEntity<TaskDTO> updateTask(@RequestBody TaskDTO taskDTO){
        logger.info("Received request to update task: {}",taskDTO);
        try{
            User user = repo1.findUserById(taskDTO.getUserId());
            Category category = repo2.findCategoryById(taskDTO.getCategoryId());

            if(user == null || category == null){
                logger.warn("Invalid user or category for update: userId={}, categoryId={}",taskDTO.getUserId(),taskDTO.getCategoryId());
                return ResponseEntity.badRequest().build();
            }

            Task task = service.createTask(
                    taskDTO.getId(),
                    taskDTO.getTitle(),
                    taskDTO.getDescription(),
                    user,
                    category,
                    taskDTO.getPriority(),
                    taskDTO.getStatus(),
                    taskDTO.getDueDate(),
                    taskDTO.getIsOverdue()
            );

            TaskDTO responseDTO = new TaskDTO(
                    task.getId(),
                    task.getTitle(),
                    task.getDescription(),
                    task.getUser().getId(),
                    task.getCategory().getId(),
                    task.getPriority(),
                    task.getStatus(),
                    task.getDueDate(),
                    task.isOverdue()
            );
            return ResponseEntity.ok(responseDTO);
        }
        catch(Exception e){
            logger.error("Error occurred while updating the task: {}",e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/deleteTask/{taskId}")
    @Operation(summary = "Delete Operation", description = "API will accept taskId and will delete the respective task.")
    public void deleteTask(@PathVariable Long taskId){
        logger.info("Request to delete task: taskId={}",taskId);
        try{
            service.deleteTask(taskId);
        }
        catch(Exception e){
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/findById")
    @Operation(summary = "Get Operation", description = "API will accept taskId and will find the respective task.")
    Task findTaskById(@RequestParam Long taskId){
        logger.info("Fetching task by ID: taskId={}",taskId);
        Task task = service.findTaskById(taskId);
        Link link1 = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TaskController.class)
                .findTaskByUser(task.getUser().getId())).withRel("getUser");
        Link link2 = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TaskController.class)
                .findTaskByCategory(task.getCategory().getId())).withRel("getCategory");
        task.add(link1);
        task.add(link2);
        logger.info("Task found: taskId={}",taskId);
        return task;
    }

    @GetMapping("/findAll")
    @Operation(summary = "Get Operation", description = "API will find all the tasks stored in the database.")
    List<Task> findAllTasks(){
        return service.findAllTasks();
    }

    @GetMapping("/findByUser/{userId}")
    @Operation(summary = "Get Operation", description = "API will accept userId and will find the respective tasks of the user.")
    List<Task> findTaskByUser(@PathVariable Long userId){
        return service.findTaskByUser_id(userId);
    }

    @GetMapping("/findByCategory")
    @Operation(summary = "Get Operation", description = "API will accept categoryId and will find the respective tasks under that category.")
    List<Task> findTaskByCategory(@RequestParam Long categoryId){
        return service.findTaskByCategory_id(categoryId);
    }

    @GetMapping("/findByPriority/{priority}")
    @Operation(summary = "Get Operation", description = "API will accept priority and will find the respective tasks under that priority.")
    List<Task> findTaskByPriority(@PathVariable String priority){
        return service.findTaskByPriority(priority);
    }

    @GetMapping("/findByStatus")
    @Operation(summary = "Get Operation", description = "API will accept status and will find the respective tasks with that status.")
    List<Task> findTaskByStatus(@RequestParam String status){
        return service.findTaskByStatus(status);
    }

//    @GetMapping("/findByDueSoon")
//    List<Task> findTaskDueSoon(){
//        return service.findTasksDueSoon();
//    }

    @GetMapping("/findByOverdue")
    @Operation(summary = "Get Operation", description = "API will find the tasks that are overdue.")
    List<Task> findOverdueTask(){
        return service.findOverdueTask();
    }

//    @GetMapping("/searchTask")
//    List<Task> searchTask(@PathVariable String keyword){
//        return service.searchTask(keyword);
//    }

    @PatchMapping("/assignToUser")
    @Operation(summary = "Patch Operation", description = "API will accept taskId, userId. It will assign that task to the user.")
    void assignTaskToUser(@RequestParam Long taskId, @RequestParam Long userId){
         service.assignTaskToUser(taskId,userId);
    }

    @PatchMapping("/changeTaskStatus/{taskId}/{status}")
    @Operation(summary = "Patch Operation", description = "API will accept taskId, status. It will assign that task with that status.")
    void changeTaskStatus(@PathVariable Long taskId, @PathVariable String status){
        service.changeTaskStatus(taskId,status);
    }

    @PatchMapping("/prioritizeTask/{taskId}/{priority}")
    @Operation(summary = "Patch Operation", description = "API will accept taskId, priority. It will assign that task with that priority.")
    void prioritizeTask(@PathVariable Long taskId,@PathVariable String priority){
        service.prioritizeTask(taskId,priority);
    }

    @GetMapping("/findByDueDateRange/{startDate}/{endDate}")
    @Operation(summary = "Get Operation", description = "API will accept startDate, EndDate. It will assign the tasks within that date range.")
    List<Task> findTaskByDueDateRange(@PathVariable String startDate,@PathVariable String endDate){
        return service.findTaskByDueDateRange(startDate,endDate);
    }

    @PostMapping("/sendNotification/{userId}/{message}")
    @Operation(summary = "Post Operation", description = "API will accept userId, message. It will send notification to the user.")
    void sendCustomerNotification(@PathVariable Long userId, @PathVariable String message){
        logger.info("Sending notification to user: userId={}, message={}",userId,message);
        service.sendCustomerNotification(userId,message);
    }
}
