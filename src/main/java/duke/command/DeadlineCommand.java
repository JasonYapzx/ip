package duke.command;

import duke.Date;
import duke.DukeException;
import duke.Task;
import duke.TaskList;
import duke.task.Deadline;
import duke.utils.Parser;
import duke.utils.Storage;

import java.io.IOException;

/**
 * Handles the "deadline" command.
 * @author Jason
 */
public class DeadlineCommand extends Command {
    private String[] commandDetails;

    public DeadlineCommand(String[] commandDetails) {
        this.commandDetails = commandDetails;
    }

    /**
     * Handles an deadline task.
     * @param taskList TaskList to add to deadline to.
     * @param storage Storage to save new deadline task.
     * @throws DukeException Deadline task has no description or improper syntax.
     */
    @Override
    public void run(TaskList taskList, Storage storage) throws DukeException, IOException {
        try {
            String[] deadlineDetails = commandDetails[1].split(" /by ", 2);

            if (deadlineDetails.length == 2) {
                Date date = Parser.parseDate(deadlineDetails[1]);
                Deadline deadline = new Deadline(deadlineDetails[0], date);
                taskList.addTask(deadline, storage);
            } else {
                throw new DukeException("☹ OOPS!!! Please follow the syntax for an " +
                        "'deadline' command: event [description] /by [date].");
            }
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("☹ OOPS!!! Please follow the syntax for an " +
                    "'deadline' command: event [description] /by [date].");
        }
    }
}
