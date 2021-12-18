import javax.swing.*;

public class Main {
    Manager myList = new Manager();

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
                    JOptionPane.showMessageDialog(null, myList.addList());
                    break;
                case "View all tasks":
                    JOptionPane.showMessageDialog(null, myList.getLists());
                    break;
                case "Update task":
                    JOptionPane.showMessageDialog(null, myList.updateTask());
                    break;
                case "Update status":
                    JOptionPane.showMessageDialog(null, myList.updateTaskStatus());
                    break;
                case "Update title":
                    JOptionPane.showMessageDialog(null, myList.updateTitle());
                    break;
                case "Update description":
                    JOptionPane.showMessageDialog(null, myList.updateDescription());
                    break;
                case "Remove task":
                    JOptionPane.showMessageDialog(null, myList.removeTask());
                    break;
                default:
                    break;
            }
        } while (!taskOption.equals("Exit"));
    }
}

