package task;

import database.DBTaskRepository;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;


public class Manager {

TaskRepository taskRepository = new DBTaskRepository();


    public ArrayList<Task> getTasks() {

        return taskRepository.getAll();
    }

    public String addTask(){

        String title = JOptionPane.showInputDialog(null, "Enter Task title",
                "Create Task", JOptionPane.QUESTION_MESSAGE);
        String description = JOptionPane.showInputDialog(null, "Enter Task description",
                "Create Task", JOptionPane.QUESTION_MESSAGE);
        String [] availableStatus = {"Active", "Done"};
        String status = (String) JOptionPane.showInputDialog(null, "Choose Task status",
                "Create Task", JOptionPane.QUESTION_MESSAGE, null, availableStatus, availableStatus[0]);
        Task task = new Task(title, description, status);
        taskRepository.create(task);

        return "Task: " + title + " added successfully";
    }


    public String updateTask() throws SQLException {
        ArrayList<Task> tasks = this.getTasks();
        Task taskToUpdate = (Task) JOptionPane.showInputDialog(null,
                "Choose Task to update",
                "Update Task",
                JOptionPane.INFORMATION_MESSAGE,
                null,
                tasks.toArray(new Task[0]),
                tasks);
        JTextField descriptionField = new JTextField(20);
        String [] availableStatus = {"Active", "Done"};
        JComboBox statusField = new JComboBox(availableStatus);
        statusField.setVisible(true);
       // JTextField statusField = new JTextField(10);
        descriptionField.setText(taskToUpdate.getDescription());
        statusField.setSelectedItem(taskToUpdate.getStatus());
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Description:"));
        myPanel.add(descriptionField);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Status:"));
        myPanel.add(statusField);

        String title = taskToUpdate.getTitle();
        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Update Task: " + title, JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String newDescription = descriptionField.getText();
            String newStatus = (String) statusField.getSelectedItem();
            taskToUpdate.setDescription(newDescription);
            taskToUpdate.setStatus(newStatus);
            taskRepository.update(taskToUpdate);

        }
        return "Task: " + title + " updated successfully!";
    }


    public String removeTask(){
        ArrayList<Task> tasks = this.getTasks();
        Task taskToRemove = (Task) JOptionPane.showInputDialog(null,
                "Choose Task to delete",
                "Delete Task",
                JOptionPane.INFORMATION_MESSAGE,
                null,
                tasks.toArray(new Task[0]),
                tasks);
        String title = taskToRemove.getTitle();
        taskRepository.delete(title);

        return "Task: " + title + " deleted successfully";
    }
}
