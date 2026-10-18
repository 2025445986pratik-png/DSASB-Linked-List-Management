
public class DoublyLinkedList {

    private static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;

    public void insertAtBeginning(int data) {
        Node n = new Node(data);

        if (head == null) {
            head = tail = n;
        } else {
            n.next = head;
            head.prev = n;
            head = n;
        }
    }

    public void insertAtEnd(int data) {
        Node n = new Node(data);

        if (tail == null) {
            head = tail = n;
        } else {
            tail.next = n;
            n.prev = tail;
            tail = n;
        }
    }

    public void insertAtPosition(int data, int pos) {
        if (pos < 1) {
            System.out.println("Invalid position.");
            return;
        }

        if (pos == 1) {
            insertAtBeginning(data);
            return;
        }

        Node cur = head;
        for (int i = 1; i < pos - 1 && cur != null; i++) {
            cur = cur.next;
        }

        if (cur == null) {
            System.out.println("Invalid position.");
            return;
        }

        if (cur == tail) {
            insertAtEnd(data);
            return;
        }

        Node n = new Node(data);
        n.next = cur.next;
        n.prev = cur;
        cur.next.prev = n;
        cur.next = n;
    }

    public void insertAfter(int target, int data) {
        Node cur = head;

        while (cur != null && cur.data != target) {
            cur = cur.next;
        }

        if (cur == null) {
            System.out.println("Value not found.");
            return;
        }

        if (cur == tail) {
            insertAtEnd(data);
            return;
        }

        Node n = new Node(data);
        n.next = cur.next;
        n.prev = cur;
        cur.next.prev = n;
        cur.next = n;
    }

    public void insertBefore(int target, int data) {
        Node cur = head;

        while (cur != null && cur.data != target) {
            cur = cur.next;
        }

        if (cur == null) {
            System.out.println("Value not found.");
            return;
        }

        if (cur == head) {
            insertAtBeginning(data);
            return;
        }

        Node n = new Node(data);
        n.prev = cur.prev;
        n.next = cur;
        cur.prev.next = n;
        cur.prev = n;
    }

    public void deleteBeginning() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    public void deleteEnd() {
        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    public void deleteAtPosition(int pos) {
        if (pos < 1 || head == null) {
            System.out.println("Invalid position or empty list.");
            return;
        }

        if (pos == 1) {
            deleteBeginning();
            return;
        }

        Node cur = head;
        for (int i = 1; i < pos && cur != null; i++) {
            cur = cur.next;
        }

        if (cur == null) {
            System.out.println("Invalid position.");
            return;
        }

        if (cur == tail) {
            deleteEnd();
            return;
        }

        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
    }

    public void deleteByValue(int value) {
        Node cur = head;

        while (cur != null && cur.data != value) {
            cur = cur.next;
        }

        if (cur == null) {
            System.out.println("Value not found.");
        } else if (cur == head) {
            deleteBeginning();
        } else if (cur == tail) {
            deleteEnd();
        } else {
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
        }
    }

    public void search(int value) {
        Node cur = head;
        int pos = 1;

        while (cur != null) {
            if (cur.data == value) {
                System.out.println("Found at position " + pos);
                return;
            }
            cur = cur.next;
            pos++;
        }

        System.out.println("Value not found.");
    }

    public void update(int oldValue, int newValue) {
        Node cur = head;

        while (cur != null) {
            if (cur.data == oldValue) {
                cur.data = newValue;
                System.out.println("Value updated.");
                return;
            }
            cur = cur.next;
        }

        System.out.println("Value not found.");
    }

    public void displayForward() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node cur = head;
        while (cur != null) {
            System.out.print(cur.data + " <-> ");
            cur = cur.next;
        }
        System.out.println("null");
    }

    public void displayBackward() {
        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }

        Node cur = tail;
        while (cur != null) {
            System.out.print(cur.data + " <-> ");
            cur = cur.prev;
        }
        System.out.println("null");
    }

    public int countNodes() {
        int count = 0;
        Node cur = head;

        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    public void findMaximum() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        int max = head.data;
        Node cur = head.next;

        while (cur != null) {
            if (cur.data > max) max = cur.data;
            cur = cur.next;
        }
        System.out.println("Maximum = " + max);
    }

    public void findMinimum() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        int min = head.data;
        Node cur = head.next;

        while (cur != null) {
            if (cur.data < min) min = cur.data;
            cur = cur.next;
        }
        System.out.println("Minimum = " + min);
    }

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

    public void reverse() {
        Node cur = head;

        while (cur != null) {
            Node temp = cur.prev;
            cur.prev = cur.next;
            cur.next = temp;
            cur = cur.prev;
        }

        Node temp = head;
        head = tail;
        tail = temp;
    }

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

    public void removeDuplicates() {
        Node cur = head;

        while (cur != null) {
            Node runner = cur.next;

            while (runner != null) {
                if (runner.data == cur.data) {
                    Node duplicate = runner;
                    runner = runner.next;

                    if (duplicate == tail) tail = duplicate.prev;
                    if (duplicate.prev != null) {
                        duplicate.prev.next = duplicate.next;
                    }
                    if (duplicate.next != null) {
                        duplicate.next.prev = duplicate.prev;
                    }
                } else {
                    runner = runner.next;
                }
            }

            cur = cur.next;
        }
    }
}
