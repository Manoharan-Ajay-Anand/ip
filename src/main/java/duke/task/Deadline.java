package duke.task;

import java.time.LocalDate;

/**
 * Represents a deadline of the user. Contains the description of the task, the completion status and the due 
 * date of the task.
 */
public class Deadline extends Task {
    private LocalDate date;

    /**
     * Creates a deadline task with the given description, completion status and the due date.
     * 
     * @param description The description of the task.
     * @param date The due date for the task.
     * @param isDone The completion status of the task.
     */
    public Deadline(String description, LocalDate date, boolean isDone) {
        super(description, isDone);
        this.date = date;
    }

    @Override
    public String toDataString() {
        return String.format("D | %d | %s | %s", isDone ? 1 : 0, this.description, this.date);
    }
    
    @Override
    public String toString() {
        return String.format("[D]%s (by: %s %d %d)", super.toString(), date.getMonth(), date.getDayOfMonth(), 
                date.getYear());
    }
}