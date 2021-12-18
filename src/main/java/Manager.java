import javax.swing.*;
import java.util.ArrayList;

public class Manager {
    private ArrayList<List> lists;


    public Manager() {
        this.lists = new ArrayList<>();
    }

    public ArrayList<List> getLists() {
        return lists;
    }

    public String addList(){

        String title = JOptionPane.showInputDialog(null, "Enter Task title",
                "Create Task", JOptionPane.QUESTION_MESSAGE);
        String description = JOptionPane.showInputDialog(null, "Enter Task description",
                "Create Task", JOptionPane.QUESTION_MESSAGE);
        String completed = JOptionPane.showInputDialog(null, "Enter Task status",
                "Create Task", JOptionPane.QUESTION_MESSAGE);
        List task = new List(title, description, completed);
        this.lists.add(task);
        return title + " added successfully";
    }
    public List findTask(String title){
        for(List list: lists){
            if(title.equals(list.getTitle())){
                return list;
            }
        }return null;
    }

    public String updateTask(){
        List listToUpdate = (List) JOptionPane.showInputDialog(null,
                "Choose List to update",
                "Update List",
                JOptionPane.INFORMATION_MESSAGE,
                null,
                this.getLists().toArray(new List[0]),
                this.getLists());
        List list = findTask(listToUpdate.getTitle());
        String title = JOptionPane.showInputDialog(null, "Enter Task new title",
                "Update Task", JOptionPane.QUESTION_MESSAGE);
        String description = JOptionPane.showInputDialog(null, "Enter Task new description",
                "Update Task", JOptionPane.QUESTION_MESSAGE);
        String completed = JOptionPane.showInputDialog(null, "Enter Task new status",
                "Update Task", JOptionPane.QUESTION_MESSAGE);
        list.setTitle(title);
        list.setDescription(description);
        list.setCompleted(completed);
        return title + " updated successfully!";
    }
    public String updateTitle(){
        List listToUpdate = (List) JOptionPane.showInputDialog(null,
                "Choose List to update",
                "Update Title",
                JOptionPane.INFORMATION_MESSAGE,
                null,
                this.getLists().toArray(new List[0]),
                this.getLists());
        List list = findTask(listToUpdate.getTitle());
        String title = JOptionPane.showInputDialog(null, "Enter Task new title",
                "Update Title", JOptionPane.QUESTION_MESSAGE);
        list.setTitle(title);
        return title + " updated successfully!";
    }
    public String updateDescription(){
        List listToUpdate = (List) JOptionPane.showInputDialog(null,
                "Choose List to update",
                "Update Description",
                JOptionPane.INFORMATION_MESSAGE,
                null,
                this.getLists().toArray(new List[0]),
                this.getLists());
        List list = findTask(listToUpdate.getTitle());
        String description = JOptionPane.showInputDialog(null, "Enter Task new description",
                "Update Description", JOptionPane.QUESTION_MESSAGE);
        list.setDescription(description);

        return list.getTitle() + " updated successfully!";
    }
    public String updateTaskStatus(){
        List listToUpdate = (List) JOptionPane.showInputDialog(null,
                "Choose List to update",
                "Update Status",
                JOptionPane.INFORMATION_MESSAGE,
                null,
                this.getLists().toArray(new List[0]),
                this.getLists());
        List list = findTask(listToUpdate.getTitle());
        String completed = JOptionPane.showInputDialog(null, "Enter Task new status",
                "Update Status", JOptionPane.QUESTION_MESSAGE);
        list.setCompleted(completed);
        return list.getTitle() + " updated successfully!";
    }

    public String removeTask(){
        List listToRemove = (List) JOptionPane.showInputDialog(null,
                "Choose List to remove",
                "Remove List",
                JOptionPane.INFORMATION_MESSAGE,
                null,
                this.getLists().toArray(new List[0]),
                this.getLists());
        List list = findTask(listToRemove.getTitle());
        lists.remove(listToRemove);
        return "List " + list.getTitle() + " removed successfully";
    }
}
