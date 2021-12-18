public class List {
    private int id;
    private String title;
    private String description;
    private String completed;

    public List(String title, String description, String completed) {
        this.title = title;
        this.description = description;
        this.completed = completed;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return  "\n"+ title +
                " " + description  +
                " status " + completed;
    }
}
