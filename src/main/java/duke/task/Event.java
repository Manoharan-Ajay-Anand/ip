package duke.task;

import java.time.LocalDate;

/** 
 * Represents an event of the user. Contains the description, the completion status and the 
 * date of the event.
 */
public class Event extends Task {
    /** The date of the event */
    private LocalDate date;

    /**
     * Constructs an Event class with the given description, completion status and the date of the event.
     * 
     * @param description The description of the event.
     * @param date The date of the event.
     * @param isDone The completion status of the event.
     */
    public Event(String description, LocalDate date, boolean isDone) {
        super(description, isDone);
        this.date = date;
    }

    @Override
    public String toDataString() {
        return String.format("E | %d | %s | %s", isDone ? 1 : 0, this.description, this.date);
    }
    
    @Override
    public String toString() {
        return String.format("[E]%s (at: %s %d %d)", super.toString(), date.getMonth(), date.getDayOfMonth(),
                date.getYear());
    }
}
