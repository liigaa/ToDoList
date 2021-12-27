package task;

import java.util.ArrayList;

public class MemoryTaskRepository implements TaskRepository {
    private ArrayList<Task> tasks = new ArrayList<>();

    @Override
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
    @Override
    public ArrayList<Task> getAll() {
        return tasks;
    }

    @Override
    public void update(Task task){
        Task taskToUpdate = findTask(task.getTitle());
        if(taskToUpdate == task){
            return;
        }
        taskToUpdate.setDescription(task.getDescription());
        taskToUpdate.setStatus(task.getStatus());
    }

    @Override
    public void delete(String title){
        Task taskToRemove = findTask(title);
        tasks.remove(taskToRemove);
    }

}
