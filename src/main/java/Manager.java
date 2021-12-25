import javax.swing.*;
import java.util.ArrayList;


public class Manager {

TaskRepository taskRepository = new TaskRepository();



    public ArrayList<Task> getTasks() {
        return taskRepository.getAll();
    }

    public String addTask(){

        String title = JOptionPane.showInputDialog(null, "Enter Task title",
                "Create Task", JOptionPane.QUESTION_MESSAGE);
        String description = JOptionPane.showInputDialog(null, "Enter Task description",
                "Create Task", JOptionPane.QUESTION_MESSAGE);
        String completed = JOptionPane.showInputDialog(null, "Enter Task status",
                "Create Task", JOptionPane.QUESTION_MESSAGE);
        Task task = new Task(title, description, completed);
        taskRepository.create(task);
        return title + " added successfully";
    }


    public String updateTask(){
        ArrayList<Task> tasks = this.getTasks();
        Task taskToUpdate = (Task) JOptionPane.showInputDialog(null,
                "Choose Task to update",
                "Update Task",
                JOptionPane.INFORMATION_MESSAGE,
                null,
                tasks.toArray(new Task[0]),
                tasks);
        JTextField descriptionField = new JTextField(20);
        JTextField statusField = new JTextField(10);
        descriptionField.setText(taskToUpdate.getDescription());
        statusField.setText(taskToUpdate.getCompleted());
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Description:"));
        myPanel.add(descriptionField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("Status:"));
        myPanel.add(statusField);

        String title = taskToUpdate.getTitle();
        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Update " + title, JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String newDescription = descriptionField.getText();
            String newStatus = statusField.getText();
            taskToUpdate.setDescription(newDescription);
            taskToUpdate.setCompleted(newStatus);
            taskRepository.update(taskToUpdate);
        }

        return title + " updated successfully!";
    }
    public String updateTitle(){
        Task listToUpdate = (Task) JOptionPane.showInputDialog(null,
                "Choose List to update",
                "Update Title",
                JOptionPane.INFORMATION_MESSAGE,
                null,
                this.getTasks().toArray(new Task[0]),
                this.getTasks());
        Task list = taskRepository.findTask(listToUpdate.getTitle());
        String title = JOptionPane.showInputDialog(null, "Enter Task new title",
                "Update Title", JOptionPane.QUESTION_MESSAGE);
        list.setTitle(title);
        return title + " updated successfully!";
    }
    public String updateDescription(){
        Task listToUpdate = (Task) JOptionPane.showInputDialog(null,
                "Choose List to update",
                "Update Description",
                JOptionPane.INFORMATION_MESSAGE,
                null,
                this.getTasks().toArray(new Task[0]),
                this.getTasks());
        Task list = taskRepository.findTask(listToUpdate.getTitle());
        String description = JOptionPane.showInputDialog(null, "Enter Task new description",
                "Update Description", JOptionPane.QUESTION_MESSAGE);
        list.setDescription(description);

        return list.getTitle() + " updated successfully!";
    }
    public String updateTaskStatus(){
        Task taskToUpdate = (Task) JOptionPane.showInputDialog(null,
                "Choose Task to update",
                "Update Status",
                JOptionPane.INFORMATION_MESSAGE,
                null,
                this.getTasks().toArray(new Task[0]),
                this.getTasks());
        Task list = taskRepository.findTask(taskToUpdate.getTitle());
        String completed = JOptionPane.showInputDialog(null, "Enter Task new status",
                "Update Status", JOptionPane.QUESTION_MESSAGE);
        list.setCompleted(completed);
        return list.getTitle() + " updated successfully!";
    }

    public String removeTask(){
        Task taskToRemove = (Task) JOptionPane.showInputDialog(null,
                "Choose List to remove",
                "Remove List",
                JOptionPane.INFORMATION_MESSAGE,
                null,
                this.getTasks().toArray(new Task[0]),
                this.getTasks());
        String title = taskToRemove.getTitle();
        taskRepository.delete(title);
        return "List " + title + " removed successfully";
    }
}
