import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    Manager myTask = new Manager();

    public static void main(String[] args) {
        Main main = new Main();
        main.menu();
    }

    void menu() {
        String taskOption;

        do {
            String[] options = {
                    "Select...", "Create task", "View all tasks", "Update task", "Update title",
                    "Update description","Update status",
                    "Remove task", "Exit"};
            taskOption = (String) JOptionPane.showInputDialog(null, """
                            Welcome to TODO List!
                            Please select choice
                            Choose EXIT to quit""",
                    "TODO list menu",
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]);
            switch (taskOption) {
                case "Create task":
                    JOptionPane.showMessageDialog(null, myTask.addTask());
                    break;
                case "View all tasks":
                    List<String> taskStrings = myTask.getTasks().stream().map(x->x.toString()).toList();
                    JOptionPane.showMessageDialog(null, String.join(",\n", taskStrings));
                    break;
                case "Update task":
                    JOptionPane.showMessageDialog(null, myTask.updateTask());
                    break;
                case "Update status":
                    JOptionPane.showMessageDialog(null, myTask.updateTaskStatus());
                    break;
                case "Update title":
                    JOptionPane.showMessageDialog(null, myTask.updateTitle());
                    break;
                case "Update description":
                    JOptionPane.showMessageDialog(null, myTask.updateDescription());
                    break;
                case "Remove task":
                    JOptionPane.showMessageDialog(null, myTask.removeTask());
                    break;
                default:
                    break;
            }
        } while (!taskOption.equals("Exit"));
    }
}

