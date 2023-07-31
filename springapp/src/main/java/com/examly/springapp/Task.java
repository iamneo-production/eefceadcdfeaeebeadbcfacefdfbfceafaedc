@Entity
public class Task {
    @Id
    private Long taskId;
    private String taskHolderName;
    private LocalDate taskDate;
    private String taskName;
    private String taskStatus;
    public Long getTaskId() {
        return taskId;
    }
    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }
    public String getTaskHolderName() {
        return taskHolderName;
    }
    public void setTaskHolderName(String taskHolderName) {
        this.taskHolderName = taskHolderName;
    }
    public LocalDate getTaskDate() {
        return taskDate;
    }
    public void setTaskDate(LocalDate taskDate) {
        this.taskDate = taskDate;
    }
    public String getTaskName() {
        return taskName;
    }
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    public String getTaskStatus() {
        return taskStatus;
    }
    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    // constructors, getters, and setters
}
