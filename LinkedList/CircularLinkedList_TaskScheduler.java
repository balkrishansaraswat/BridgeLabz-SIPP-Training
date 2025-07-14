package LInkedList;

public class CircularLinkedList_TaskScheduler  {
     static class Task {
        int taskId;
        String taskName, dueDate;
        int priority;
        Task next;

        Task(int taskId, String taskName, int priority, String dueDate) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.priority = priority;
            this.dueDate = dueDate;
        }
    }

    Task head = null, tail = null;

    public void addTask(int id, String name, int priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            newTask.next = head;
        } else {
            tail.next = newTask;
            tail = newTask;
            tail.next = head;
        }
    }

    public void displayTasks() {
        if (head == null) return;
        Task temp = head;
        do {
            System.out.println("ID: " + temp.taskId + ", Name: " + temp.taskName +
                ", Priority: " + temp.priority + ", Due: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    public void removeTask(int taskId) {
        if (head == null) return;
        Task curr = head, prev = tail;
        do {
            if (curr.taskId == taskId) {
                if (curr == head) head = head.next;
                if (curr == tail) tail = prev;
                prev.next = curr.next;
                if (curr == head && curr == tail) head = tail = null;
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    public Task searchByPriority(int p) {
        if (head == null) return null;
        Task temp = head;
        do {
            if (temp.priority == p) return temp;
            temp = temp.next;
        } while (temp != head);
        return null;
    }

    public static void main(String[] args) {
        CircularLinkedList_TaskScheduler scheduler = new CircularLinkedList_TaskScheduler();
        scheduler.addTask(1, "Task A", 1, "2025-07-15");
        scheduler.addTask(2, "Task B", 2, "2025-07-16");
        scheduler.addTask(3, "Task C", 3, "2025-07-17");
        scheduler.displayTasks();
        scheduler.removeTask(2);
        System.out.println("After removing task 2:");
        scheduler.displayTasks();
    }
}
