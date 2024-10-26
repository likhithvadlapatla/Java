package com.ge.stepdefinitions;

import com.ge.model.Category;
import com.ge.model.Task;
import com.ge.model.User;
import com.ge.service.ITaskService;
import com.ge.service.IUserService;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class TaskStepDefinition {

    @Autowired
    private IUserService service1;

    @Autowired
    private ITaskService service2;

    Task task;

    private String errorMessage;

    @Given("I am a logged-in user with ID {long}")
    public void login(Long userId) {
        List<Long> userIds = service1.findAllUsers().stream().map(User::getId).toList();
        assertTrue(userIds.contains(userId),"User Id should be present in the list");
    }
    @When("I created a task with the following details:")
    public void createTask(DataTable dataTable) {
        Map<String, String> taskDetails = dataTable.asMaps(String.class, String.class).get(0);
        
        Long id = Long.parseLong(taskDetails.get("id"));
        String title = taskDetails.get("title");
        String description = taskDetails.get("description");
        String priority = taskDetails.get("priority");
        String status = taskDetails.get("status");
        LocalDate dueDate = LocalDate.parse(taskDetails.get("dueDate"));
        boolean isOverdue = Boolean.parseBoolean(taskDetails.get("isOverdue"));

        User user = new User();
        user.setId(1L);
        Category category = new Category();
        category.setId(1L);

        service2.createTask(id, title, description, user, category, priority, status, dueDate, isOverdue);

    }
    @Then("the task with title {string} should be saved")
    public void saveTask(String title) {
        List<String> taskTitles = service2.findAllTasks().stream().map(Task::getTitle).toList();
        System.out.println(taskTitles);
        assertTrue(taskTitles.contains(title));
    }

    @Given("a task with ID {long} exists")
    public void aTaskWithIDExists(long taskId) {
        task = service2.findTaskById(taskId);
        assertNotNull(task);
    }

    /*When using regular expression in a particular line, that line has to start with ^ and end with $.*/
    @When("^I update the priority to \"([a-zA-Z]+)\"$")
    public void iUpdateThePriorityTo(String priority) {
        if(task != null){
            task.setId(task.getId());
            task.setTitle(task.getTitle());
            task.setDescription(task.getDescription());
            task.setPriority(priority);
            task.setStatus(task.getStatus());
            task.setDueDate(task.getDueDate());
            task.setOverdue(task.isOverdue());

            Exception exception = assertThrows(Exception.class, ()->{
                service2.updateTask(task);
            });
        }
    }

    @Then("the task should be updated with priority {string}")
    public void theTaskShouldBeUpdatedSuccessfully(String priority) {
            assertEquals(task.getPriority(), priority);
    }

    @Given("no task exists with ID {long}")
    public void noTaskExistsWithID(Long taskId) {
        List<Long> taskIds = service2.findAllTasks().stream().map(Task::getId).toList();
        assertFalse(taskIds.contains(taskId));
    }

    @When("I update the task with the following details:")
    public void iUpdateTheTheTaskWithTheFollowingDetails(DataTable dataTable) {
        Map<String, String> taskDetails = dataTable.asMaps(String.class,String.class).get(0);

        Long taskId = Long.parseLong(taskDetails.get("id"));
        String title = taskDetails.get("title");
        String description = taskDetails.get("description");
        String priority = taskDetails.get("priority");
        String status = taskDetails.get("status");
        LocalDate dueDate = LocalDate.parse(taskDetails.get("dueDate"));
        boolean isOverdue = Boolean.parseBoolean(taskDetails.get("isOverdue"));

        User user = new User();
        user.setId(1L);
        Category category = new Category();
        category.setId(1L);

        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);
        task.setPriority(priority);
        task.setStatus(status);
        task.setDueDate(dueDate);
        task.setOverdue(isOverdue);

        assertThrows(Exception.class, ()->
                service2.updateTask(task));
    }

    @Then("the task with ID {long} should not be updated with status {string}")
    public void theTaskShouldNotBeUpdatedWithStatus(Long taskId, String status) {
        assertNull(service2.findTaskById(taskId));
    }

    @When("I delete a task with ID {long}")
    public void iDeleteATaskWithID(long taskId) {
        service2.deleteTask(taskId);
    }

    @Then("the task should be deleted")
    public void theTaskShouldBeDeleted() {
        List<Long> taskIds = service2.findAllTasks().stream().map(Task::getId)
                        .toList();
        assertFalse(taskIds.contains(task.getId()));
    }

    @When("I delete the task with the following details:")
    public void iDeleteTheTaskWithTheFollowingDetails(DataTable dataTable) {
        Map<String, String> taskDetails = dataTable.asMaps(String.class,String.class).get(0);
        Long taskId = Long.parseLong(taskDetails.get("id"));
        task = service2.findTaskById(taskId);
        assertThrows(Exception.class, ()->
                service2.updateTask(task));
    }

    @Then("the task with ID {long} should not be deleted")
    public void theTaskWithIDShouldNotBeDeleted(long taskId) {
        assertNull(service2.findTaskById(taskId));
    }
}
