package LInkedList;

public class DoublyLinkedList_MovieManagement {
      static class Movie {
        String title, director;
        int year;
        double rating;
        Movie next, prev;

        Movie(String title, String director, int year, double rating) {
            this.title = title;
            this.director = director;
            this.year = year;
            this.rating = rating;
        }
    }

    Movie head = null, tail = null;

    public void addAtEnd(String title, String director, int year, double rating) {
        Movie newNode = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void displayForward() {
        Movie temp = head;
        while (temp != null) {
            System.out.println(temp.title + " (" + temp.year + ") by " + temp.director + " - Rating: " + temp.rating);
            temp = temp.next;
        }
    }

    public void displayBackward() {
        Movie temp = tail;
        while (temp != null) {
            System.out.println(temp.title + " (" + temp.year + ") by " + temp.director + " - Rating: " + temp.rating);
            temp = temp.prev;
        }
    }

    public void removeByTitle(String title) {
        Movie temp = head;
        while (temp != null && !temp.title.equalsIgnoreCase(title)) temp = temp.next;
        if (temp == null) return;
        if (temp == head) head = head.next;
        if (temp == tail) tail = tail.prev;
        if (temp.prev != null) temp.prev.next = temp.next;
        if (temp.next != null) temp.next.prev = temp.prev;
    }

    public void updateRating(String title, double newRating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                return;
            }
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList_MovieManagement mms = new DoublyLinkedList_MovieManagement();
        mms.addAtEnd("Inception", "Nolan", 2010, 9.0);
        mms.addAtEnd("Interstellar", "Nolan", 2014, 8.6);
        mms.addAtEnd("Tenet", "Nolan", 2020, 7.8);
        mms.displayForward();
        mms.updateRating("Tenet", 8.0);
        mms.removeByTitle("Inception");
        System.out.println("After update and delete:");
        mms.displayForward();
        System.out.println("Reverse order:");
        mms.displayBackward();
    }
}
