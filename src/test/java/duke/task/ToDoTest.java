package duke.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToDoTest {
    @Test
    public void testToString() {
        ToDo todo = new ToDo("brush teeth", false);
        assertEquals("[T][ ] brush teeth", todo.toString());
        todo.markAsDone();
        assertEquals("[T][X] brush teeth", todo.toString());
    }

    @Test
    public void testToDataString() {
        ToDo todo = new ToDo("brush teeth", false);
        assertEquals("T | 0 | brush teeth", todo.toDataString());
        todo.markAsDone();
        assertEquals("T | 1 | brush teeth", todo.toDataString());
    }
}