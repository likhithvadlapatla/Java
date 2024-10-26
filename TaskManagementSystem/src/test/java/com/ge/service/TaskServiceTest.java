//package com.ge.service;
//
//import com.ge.model.Category;
//import com.ge.model.Task;
//import com.ge.model.User;
//import com.ge.repository.ITaskRepo;
//import com.ge.repository.IUserRepo;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.time.LocalDate;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//import static org.mockito.Mockito.when;
//
//public class TaskServiceTest {
//
//    @Mock
//    private ITaskRepo repo1;
//
//    @Mock
//    private IUserRepo repo2;
//
//    /*
//        What Does @InjectMocks Do?
//
//        Imagine you have a class (TaskServiceImpl) that needs some helpers (like ITaskRepo and IUserRepo) to do its job. In testing, these helpers are often mocked (fake versions) so you can test the class in isolation.
//        Here’s how @InjectMocks fits in:
//        Creates the Class Under Test: @InjectMocks automatically creates an instance of the class you want to test (TaskServiceImpl).
//        Injects Mock Helpers: It then takes the mocks (fake versions of ITaskRepo and IUserRepo) and automatically injects them into this instance. This means you don’t have to manually set these mocks in your test.
//     */
//    @InjectMocks
//    private TaskServiceImpl service;
//
//    @BeforeEach
//    void setup(){
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void createTask_Success(){
//        User user = new User();
//        user.setId(1L);
//        Category category = new Category();
//        category.setId(1L);
//
//        Task task = new Task();
//        task.setTitle("Test Task");
//        task.setDescription("Task Description");
//        task.setUser(user);
//        task.setCategory(category);
//        task.setPriority("High");
//        task.setStatus("Pending");
//        task.setDueDate(LocalDate.now().plusDays(1));
//        task.setOverdue(false);
//
//        /*
//            Mockito is handling the creation and behavior of the object during testing. Specifically:
//
//            taskRepo.save(any(Task.class)):
//            The taskRepo here is a mock object, not the actual repository. In tests, you don't need the real taskRepo to interact with a database.
//            any(Task.class) is a Mockito matcher. It tells Mockito to match any Task object passed into the save() method of taskRepo.
//            When the taskService.createTask() method inside your test calls taskRepo.save(), Mockito intercepts that call.
//
//            .thenReturn(task):
//            This part tells Mockito what to do when taskRepo.save(any(Task.class)) is called. Instead of actually saving the object to a database (which happens in real application code), it will return the mock task object that you have predefined in your test.
//            So, in the test case, the mock object (taskRepo) will "send" or return the predefined task object when the save() method is called. This allows you to test how the service behaves without needing to connect to a real database.
//
//            Even if a different object is passed to the method specified in the when clause, Mockito will return the predefined object set up in the thenReturn clause. This means the return value is not influenced by the actual object passed in but is instead fixed to the object specified in the thenReturn.
//         */
//        when(repo1.save(any(Task.class))).thenReturn(task);
//        Task createdTask = service.createTask(1L,"Test Task","Task Description",user,category,"High","Pendin",LocalDate.now().plusDays(1),false);
//
//        assertNotNull(createdTask);
//        assertEquals("Test Task",createdTask.getTitle());
//        assertNotEquals("Task Description Created",createdTask.getDescription());
//        assertEquals("Pendin",createdTask.getStatus());
//        verify(repo1,times(1)).save(any(Task.class));
//    }
//}
