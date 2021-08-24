package duke;

import duke.command.Command;
import duke.command.CommandType;
import duke.exception.DukeException;
import duke.storage.Storage;
import duke.storage.TaskList;
import duke.task.Task;
import duke.ui.Ui;

import java.util.ArrayList;

/**
 * Represents the main Duke application.
 */
public class Duke {
    
    private Storage storage;
    private TaskList taskList;
    private Ui ui;

    /**
     * Constructs a Duke class with the given data file.
     * 
     * @param filePath The path of the data file for the application
     */
    public Duke(String filePath) {
        this.storage = new Storage(filePath);
        this.ui = new Ui();
        try {
            this.taskList = new TaskList(storage.load());
        } catch (DukeException e) {
            ui.displayErrorMessage(e.getMessage());
            this.taskList = new TaskList(new ArrayList<>());
        }
    }

    /**
     * Starts the Duke application with the UI. Writes to the data file after being closed by the user.
     */
    public void run() {
        ui.greet();
        while (true) {
            try {
                Command command = ui.receiveCommand();
                if (command.type == CommandType.BYE) {
                    ui.sayGoodbye();
                    break;
                } else if (command.type == CommandType.ADD) {
                    Task task = (Task) command.payload;
                    taskList.add(task);
                    ui.displayAddedTask(task, taskList.getTaskCount());
                } else if (command.type == CommandType.DONE) {
                    int serialNo = (int) command.payload;
                    ui.displayDoneTask(taskList.markDone(serialNo));
                } else if (command.type == CommandType.DELETE) {
                    int serialNo = (int) command.payload;
                    ui.displayRemovedTask(taskList.remove(serialNo), taskList.getTaskCount());
                } else if (command.type == CommandType.LIST) {
                    ui.displayTasks(taskList.getTasks());
                }
            } catch (DukeException e) {
                ui.displayErrorMessage(e.getMessage());
            }
        }
        ui.close();
        storage.write(taskList.getTasks());
    }
    
    public static void main(String[] args) {
        new Duke("duke.txt").run();
    }
}