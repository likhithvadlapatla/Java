Feature: Task

  @creation
  Scenario: Task creation
    Given I am a logged-in user with ID 1
    When I created a task with the following details:
      | id   | title           | description       | priority | status | dueDate    | isOverdue |
      | 1001 | Complete report | Finish the report | High     | Open   | 2024-09-20 | false     |
    Then the task with title "Complete report" should be saved

  @updation @success
  Scenario: Successful task update
    Given a task with ID 10 exists
    When I update the priority to "Medium"
    Then the task should be updated with priority "Medium"

  @updation @failure
  Scenario: Task update fails due to invalid task ID
    Given no task exists with ID 99
    When I update the task with the following details:
      | id | title           | description       | priority | status | dueDate    | isOverdue |
      | 99 | Complete report | Finish the report | High     | Open   | 2024-09-20 | false     |
    Then the task with ID 99 should not be updated with status "In Progress"

  @deletion @success
  Scenario: Successful task deletion
    Given a task with ID 10 exists
    When I delete a task with ID 10
    Then the task should be deleted

  @deletion @failure
  Scenario: Task delete fails due to invalid task ID
    Given no task exists with ID 99
    When I delete the task with the following details:
      | id |
      | 99 |
    Then the task with ID 99 should not be deleted



