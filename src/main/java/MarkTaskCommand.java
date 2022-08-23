import java.io.IOException;

public class MarkTaskCommand extends Command {
    private String taskIndex;

    public MarkTaskCommand(String taskIndex) {
        this.taskIndex = taskIndex;
    }

    /**
     *
     * @param taskList TaskList to update the task that is marked
     * @param storage Storage to save marked task
     * @throws DukeException Index out of bounds / Uncreated task index
     */
    @Override
    public void run(TaskList taskList, Storage storage) throws DukeException, IOException {
        int index = Integer.parseInt(taskIndex) - 1;
        try {
            taskList.get(index).markAsDone();
            String message = "Nice! I've marked this task as done: \n  " +
                    taskList.get(index) + "\n";
            Ui.printMessage(message);
        } catch (NullPointerException e) {
            throw new DukeException("☹ OOPS!!! There is no task created for this index!");
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DukeException("☹ OOPS!!! Please enter a valid index number!");
        }

        //Saving data
        storage.saveData(taskList.getList());
    }
}
