package task;

import java.util.ArrayList;

public interface TaskRepository {
    void create(Task task);



    ArrayList<Task> getAll();

    void update(Task task);

    void delete(String title);
}
