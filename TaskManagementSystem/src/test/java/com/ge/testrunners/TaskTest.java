package com.ge.testrunners;

import com.ge.app.LaunchApplication;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/task.feature"},
        glue = {"com.ge.stepdefinitions"},
        tags = "@success",
        plugin = {"pretty", "html:target/cucumber-reports"},
        monochrome = true
)
@CucumberContextConfiguration
@SpringBootTest(classes = LaunchApplication.class)
public class TaskTest {
}
