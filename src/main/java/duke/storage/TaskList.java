package duke.storage;

import duke.task.Task;

import java.util.List;

/**
 * Represents a Task list that can be added to and removed from.
 */
public class TaskList {
    private List<Task> tasks;

    /**
     * Creates a task list with a given initial list of tasks.
     * 
     * @param tasks The initial list of tasks.
     */
    public TaskList(List<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Adds a task to the existing list of tasks.
     * 
     * @param task The task to be added.
     */
    public void add(Task task) {
        this.tasks.add(task);
    }

    /**
     * Removes a task by its serial number from the list. Returns the task that was removed.
     * 
     * @param serialNo The serial number of the task to remove.
     * @return The task that was removed.
     */
    public Task remove(int serialNo) {
        return this.tasks.remove(serialNo - 1);
    }

    /**
     * Marks a task with the given serial number as done.
     * 
     * @param serialNo The serial number of the task to be marked.
     * @return The task that was marked.
     */
    public Task markDone(int serialNo) {
        Task task = tasks.get(serialNo - 1);
        task.markAsDone();
        return task;
    }

    /**
     * Returns the current list of tasks.
     * 
     * @return The current list of tasks.
     */
    public List<Task> getTasks() {
        return tasks;
    }

    /**
     * Returns the number of tasks in the task list.
     * 
     * @return The number of tasks in the list.
     */
    public int getTaskCount() {
        return tasks.size();
    }
}
