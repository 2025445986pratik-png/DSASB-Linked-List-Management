
public class SinglyLinkedList {

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    // 1. Insert at beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // 2. Insert at end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // 3. Insert at a 1-based position
    public void insertAtPosition(int data, int position) {
        if (position < 1) {
            System.out.println("Invalid position.");
            return;
        }

        if (position == 1) {
            insertAtBeginning(data);
            return;
        }

        Node current = head;

        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Invalid position.");
            return;
        }

        Node newNode = new Node(data);
        newNode.next = current.next;
        current.next = newNode;
    }

    // 4. Insert after the first matching value
    public void insertAfter(int target, int data) {
        Node current = head;

        while (current != null && current.data != target) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Value not found.");
            return;
        }

        Node newNode = new Node(data);
        newNode.next = current.next;
        current.next = newNode;
    }

    // 5. Insert before the first matching value
    public void insertBefore(int target, int data) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.data == target) {
            insertAtBeginning(data);
            return;
        }

        Node current = head;

        while (current.next != null && current.next.data != target) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Value not found.");
            return;
        }

        Node newNode = new Node(data);
        newNode.next = current.next;
        current.next = newNode;
    }

    // 6. Delete from beginning
    public void deleteBeginning() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        head = head.next;
    }

    // 7. Delete from end
    public void deleteEnd() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node current = head;

        while (current.next.next != null) {
            current = current.next;
        }

        current.next = null;
    }

    // 8. Delete at a 1-based position
    public void deleteAtPosition(int position) {
        if (position < 1 || head == null) {
            System.out.println("Invalid position or empty list.");
            return;
        }

        if (position == 1) {
            deleteBeginning();
            return;
        }

        Node current = head;

        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null || current.next == null) {
            System.out.println("Invalid position.");
            return;
        }

        current.next = current.next.next;
    }

    // 9. Delete first occurrence of a value
    public void deleteByValue(int value) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.data == value) {
            deleteBeginning();
            return;
        }

        Node current = head;

        while (current.next != null && current.next.data != value) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Value not found.");
            return;
        }

        current.next = current.next.next;
    }

    // 10. Search
    public void search(int value) {
        Node current = head;
        int position = 1;

        while (current != null) {
            if (current.data == value) {
                System.out.println("Found at position " + position);
                return;
            }

            current = current.next;
            position++;
        }

        System.out.println("Value not found.");
    }

    // 11. Update first matching value
    public void update(int oldValue, int newValue) {
        Node current = head;

        while (current != null) {
            if (current.data == oldValue) {
                current.data = newValue;
                System.out.println("Value updated.");
                return;
            }
            current = current.next;
        }

        System.out.println("Value not found.");
    }

    // 12. Display
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }

    // 13. Count nodes
    public int countNodes() {
        int count = 0;
        Node current = head;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    // 14. Find maximum
    public void findMaximum() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        int maximum = head.data;
        Node current = head.next;

        while (current != null) {
            if (current.data > maximum) {
                maximum = current.data;
            }
            current = current.next;
        }

        System.out.println("Maximum = " + maximum);
    }

    // 15. Find minimum
    public void findMinimum() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        int minimum = head.data;
        Node current = head.next;

        while (current != null) {
            if (current.data < minimum) {
                minimum = current.data;
            }
            current = current.next;
        }

        System.out.println("Minimum = " + minimum);
    }

    // 16. Find middle (second middle for even-sized lists)
    public void findMiddle() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println("Middle = " + slow.data);
    }

    // 17. Reverse
    public void reverse() {
        Node previous = null;
        Node current = head;

        while (current != null) {
            Node nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }

        head = previous;
    }

    // 18. Sort in ascending order
    public void sort() {
        for (Node i = head; i != null; i = i.next) {
            for (Node j = i.next; j != null; j = j.next) {
                if (i.data > j.data) {
                    int temp = i.data;
                    i.data = j.data;
                    j.data = temp;
                }
            }
        }
    }

    // 19. Remove duplicates
    public void removeDuplicates() {
        Node current = head;

        while (current != null) {
            Node runner = current;

            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }

            current = current.next;
        }
    }
}
