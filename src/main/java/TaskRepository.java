import java.util.ArrayList;

public class TaskRepository {
    private ArrayList<Task> tasks = new ArrayList<>();

    public void create(Task task){
        this.tasks.add(task);
    }

    public Task findTask(String title){
        for(Task list: tasks){
            if(title.equals(list.getTitle())){
                return list;
            }
        }return null;
    }
    public ArrayList<Task> getAll() {
        return tasks;
    }

    public void update(Task task){
        Task taskToUpdate = findTask(task.getTitle());
        if(taskToUpdate == task){
            return;
        }
        taskToUpdate.setDescription(task.getDescription());
        taskToUpdate.setCompleted(task.getCompleted());

    }

    public void delete(String title){
        Task taskToRemove = findTask(title);
        tasks.remove(taskToRemove);
    }

}
