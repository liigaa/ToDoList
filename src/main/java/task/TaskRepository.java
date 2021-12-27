package task;

import java.util.ArrayList;

public interface TaskRepository {
    void create(Task task);


    ArrayList<Task> getAll();
    ArrayList<Task>getActive();

    void update(Task task);

    void delete(String title);
}
