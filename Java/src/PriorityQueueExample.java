import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        // Creating a priority queue
        PriorityQueue<Task> priorityQueue = new PriorityQueue<>();

        // Adding tasks with priorities
        priorityQueue.add(new Task("Task 1: High Priority", 3));
        priorityQueue.add(new Task("Task 2: Medium Priority", 2));
        priorityQueue.add(new Task("Task 3: Low Priority", 1));

        // Changing the priority of a task
        Task taskToChange = new Task("Task 3: Low Priority", 1); // Task with old priority
        Task newTask = new Task("Task 3: High Priority", 3); // Task with new priority
        priorityQueue.remove(taskToChange); // Removing task with old priority
        priorityQueue.add(newTask); // Adding task with new priority

        // Displaying elements in priority order
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
    }
}

class Task implements Comparable<Task> {
    private String name;
    private int priority;

    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Task other) {
        // Higher priority tasks should come first
        return Integer.compare(other.priority, this.priority);
    }

    @Override
    public String toString() {
        return name;
    }
}