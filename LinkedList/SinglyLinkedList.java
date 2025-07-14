package LInkedList;

public class SinglyLinkedList {
    static class Student {
        int rollNumber;
        String name;
        int age;
        String grade;
        Student next;

        Student(int rollNumber, String name, int age, String grade) {
            this.rollNumber = rollNumber;
            this.name = name;
            this.age = age;
            this.grade = grade;
            this.next = null;
        }
    }

    Student head = null;

    public void addAtBeginning(int roll, String name, int age, String grade) {
        Student newNode = new Student(roll, name, age, grade);
        newNode.next = head;
        head = newNode;
    }

    public void addAtEnd(int roll, String name, int age, String grade) {
        Student newNode = new Student(roll, name, age, grade);
        if (head == null) {
            head = newNode;
            return;
        }
        Student temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
    }

    public void deleteByRoll(int roll) {
        if (head == null) return;
        if (head.rollNumber == roll) {
            head = head.next;
            return;
        }
        Student temp = head;
        while (temp.next != null && temp.next.rollNumber != roll)
            temp = temp.next;
        if (temp.next != null)
            temp.next = temp.next.next;
    }

    public Student searchByRoll(int roll) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == roll)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    public void updateGrade(int roll, String newGrade) {
        Student student = searchByRoll(roll);
        if (student != null) {
            student.grade = newGrade;
        }
    }

    public void displayAll() {
        Student temp = head;
        while (temp != null) {
            System.out.println("Roll: " + temp.rollNumber + ", Name: " + temp.name +
                ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
       SinglyLinkedList  records = new SinglyLinkedList ();
        records.addAtEnd(1, "Alice", 20, "A");
        records.addAtBeginning(2, "Bob", 21, "B");
        records.addAtEnd(3, "Charlie", 22, "C");
        records.displayAll();
        records.updateGrade(2, "A+");
        records.deleteByRoll(1);
        System.out.println("After Update and Delete:");
        records.displayAll();
    }
}
