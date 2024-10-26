package com.ge.app;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

/*Usually the instance is created before every test you run(That is the default behaviour. But to change it to creating only once you need to use @TestInstance(TestInstance.Lifecycle.PER_CLASS) annotation.*/
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ShapesTest {

    /*Here we are creating a constructor to check how many times the instance is being created because constructor gets executed during instance creation.*/
    public ShapesTest(){
        System.out.println("Only one instance is created.");
    }

    /*The method annotated with @BeforeAll gets executed before all the test cases gets executed.It is only executed once.*/
    /*That method should be declared static too because it gets executed even before the instance of the class is created.(FYI Static methods are executed first when you run the program, Also you can't create objects inside static methods.).*/
    @BeforeAll
    static void beforeAll(){
        System.out.println("Before all the tests.");
    }

    /*The method annotated with @AfterAll gets executed after all the test cases gets executed.It is only executed once.*/
    /*This should be declared static since @AfterAll methods are designed to perform cleanup or tear down operations for the entire class, they do not operate on specific instances of the test class. Therefore, they do not require an instance of the test class to be executed.*/
    @AfterAll
    static void afterAll(){
        System.out.println("After all the tests.");
    }

    Shapes shape;

    /*The method annotated with @BeforeEach annotation gets executed before each test case gets executed.*/
    @BeforeEach
    void init(){
        /*Even though this method gets executed before each method because of the @TestInstance(TestInstance.Lifecycle.PER_CLASS) annotation only one instance of Shapes gets created.*/
        shape = new Shapes();
        System.out.println("Before each test.");
    }

    @Test
    void testComputeSquareArea1()
    {
        assertEquals(25, shape.computeSquareArea(5));
        System.out.println("Actual test running");
    }

    @Test
    /*The method with @Disabled annotation will not be considered during execution.*/
    @Disabled
    void sampleTest1(){
        System.out.println("Sample Test 1");
    }

    @Test
    /*This @EnabledOnOs annotation is useful when you want to run the test case on specific operating system.*/
    /*Here in this case this method only gets executed if you are running from MAC operating system.*/
    @EnabledOnOs(OS.MAC)
    void sampleTest2(){
        System.out.println("Sample Test 2");
    }

    /*This @EnabledOnJre is useful when you want to run the test case on specific java environment.*/
    /*Here in this case this method only gets executed if you are running from JDK 11.*/
    @Test
    @EnabledOnJre(JRE.JAVA_11)
    void sampleTest3(){
        System.out.println("Sample Test 3");
    }

    @Test
    /*This @EnabledForJreRange is useful when you want to run the test case on specific range of java versions.*/
    /*Here in this case this method only gets executed if you are running from JDK versions 8 to 17(included).*/
    @EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_17)
    void sampleTest4(){
        System.out.println("Sample Test 4");
    }

    @Test
    void sampleTest5(){
        String s = "Likhith";
        /*Assumptions are used to enable conditional based testing.*/
        /*Here if the value inside the method is true, the statements below it gets executed or else they won't execute.*/
        assumeTrue(s.length()<5);
        System.out.println("Sample Test 5");
    }

    @Test
    void sampleTest6(){
        String s = "Likhith";
        /*Assumptions are used to enable conditional based testing.*/
        /*Here if the value inside the method is false, the statements below it gets executed or else they won't execute.*/
        assumeFalse(s.length()<5);
        System.out.println("Sample Test 6");
    }

    @Test
    /*The @DisplayName method annotation is helpful to display the text inside it during the execution of the tests inside the file instead of displaying the method name.*/
    /*This annotation gets handy when you have more test cases. This helps you to locate to the testcase that is failing easily.*/
    @DisplayName("Testing area of circle method.")
    void testComputeCircleArea1()
    {
        assertEquals(78.5, shape.computeCircleArea(5));
        System.out.println("Actual test running");
    }

    /*@Nested annotation is useful to group the tests that are similar.*/
    /*This annotation is applied to a class inside a class. This comes handy if there are more test cases.*/
    @Nested
    class ComputeCircleAreaTests{

        @Test
        void testComputeCircleArea2()
        {
            assertEquals(12.56, shape.computeCircleArea(2));
            System.out.println("Actual test running");
        }

        @Test
        void testComputeCircleArea1()
        {
            assertEquals(3.14, shape.computeCircleArea(1));
            System.out.println("Actual test running");
        }
    }

    @Nested
    class ComputeSquareAreaTests{

        @Test
        void testComputeSquareArea12()
        {
            assertEquals(4, shape.computeSquareArea(2));
            System.out.println("Actual test running");
        }

        @Test
        void testComputeSquareArea3()
        {
            assertEquals(9, shape.computeSquareArea(3));
            System.out.println("Actual test running");
        }
    }



    /*The method annotated with @AfterEach annotation gets executed after each test case gets executed.*/
    @AfterEach
    void destroy(){
        System.out.println("After test clean up.");
    }

}
