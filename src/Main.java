
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        SinglyLinkedList singly = new SinglyLinkedList();
        DoublyLinkedList doubly = new DoublyLinkedList();

        int choice;

        do {
            System.out.println("\n===== DSASB LINKED LIST MANAGEMENT SYSTEM =====");
            System.out.println("1. Singly Linked List");
            System.out.println("2. Doubly Linked List");
            System.out.println("3. Compare Singly vs Doubly");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    singlyMenu(singly);
                    break;

                case 2:
                    doublyMenu(doubly);
                    break;

                case 3:
                    compareLists();
                    break;

                case 4:
                    System.out.println("Thank you for using DSASB!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 4);

        sc.close();
    }

    // SINGLY LINKED LIST MENU
    static void singlyMenu(SinglyLinkedList list) {

        int choice;

        do {
            System.out.println("\n--- SINGLY LINKED LIST ---");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Insert After a Value");
            System.out.println("5. Insert Before a Value");
            System.out.println("6. Delete from Beginning");
            System.out.println("7. Delete from End");
            System.out.println("8. Delete from Position");
            System.out.println("9. Delete by Value");
            System.out.println("10. Search");
            System.out.println("11. Update");
            System.out.println("12. Display");
            System.out.println("13. Count Nodes");
            System.out.println("14. Find Maximum");
            System.out.println("15. Find Minimum");
            System.out.println("16. Find Middle");
            System.out.println("17. Reverse");
            System.out.println("18. Sort");
            System.out.println("19. Remove Duplicates");
            System.out.println("20. Back to Main Menu");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    list.insertAtBeginning(sc.nextInt());
                    break;

                case 2:
                    System.out.print("Enter value: ");
                    list.insertAtEnd(sc.nextInt());
                    break;

                case 3:
                    System.out.print("Enter value: ");
                    int value = sc.nextInt();
                    System.out.print("Enter position: ");
                    int pos = sc.nextInt();
                    list.insertAtPosition(value, pos);
                    break;

                case 4:
                    System.out.print("Insert after which value? ");
                    int targetAfter = sc.nextInt();
                    System.out.print("Enter new value: ");
                    int valueAfter = sc.nextInt();
                    list.insertAfter(targetAfter, valueAfter);
                    break;

                case 5:
                    System.out.print("Insert before which value? ");
                    int targetBefore = sc.nextInt();
                    System.out.print("Enter new value: ");
                    int valueBefore = sc.nextInt();
                    list.insertBefore(targetBefore, valueBefore);
                    break;

                case 6:
                    list.deleteBeginning();
                    break;

                case 7:
                    list.deleteEnd();
                    break;

                case 8:
                    System.out.print("Enter position: ");
                    list.deleteAtPosition(sc.nextInt());
                    break;

                case 9:
                    System.out.print("Enter value to delete: ");
                    list.deleteByValue(sc.nextInt());
                    break;

                case 10:
                    System.out.print("Enter value to search: ");
                    list.search(sc.nextInt());
                    break;

                case 11:
                    System.out.print("Enter old value: ");
                    int oldValue = sc.nextInt();
                    System.out.print("Enter new value: ");
                    int newValue = sc.nextInt();
                    list.update(oldValue, newValue);
                    break;

                case 12:
                    list.display();
                    break;

                case 13:
                    System.out.println("Total nodes: " + list.countNodes());
                    break;

                case 14:
                    list.findMaximum();
                    break;

                case 15:
                    list.findMinimum();
                    break;

                case 16:
                    list.findMiddle();
                    break;

                case 17:
                    list.reverse();
                    System.out.println("List reversed.");
                    break;

                case 18:
                    list.sort();
                    System.out.println("List sorted.");
                    break;

                case 19:
                    list.removeDuplicates();
                    System.out.println("Duplicates removed.");
                    break;

                case 20:
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 20);
    }

    // DOUBLY LINKED LIST MENU
    static void doublyMenu(DoublyLinkedList list) {

        int choice;

        do {
            System.out.println("\n--- DOUBLY LINKED LIST ---");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Insert After a Value");
            System.out.println("5. Insert Before a Value");
            System.out.println("6. Delete from Beginning");
            System.out.println("7. Delete from End");
            System.out.println("8. Delete from Position");
            System.out.println("9. Delete by Value");
            System.out.println("10. Search");
            System.out.println("11. Update");
            System.out.println("12. Display Forward");
            System.out.println("13. Display Backward");
            System.out.println("14. Count Nodes");
            System.out.println("15. Find Maximum");
            System.out.println("16. Find Minimum");
            System.out.println("17. Find Middle");
            System.out.println("18. Reverse");
            System.out.println("19. Sort");
            System.out.println("20. Remove Duplicates");
            System.out.println("21. Back to Main Menu");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    list.insertAtBeginning(sc.nextInt());
                    break;

                case 2:
                    System.out.print("Enter value: ");
                    list.insertAtEnd(sc.nextInt());
                    break;

                case 3:
                    System.out.print("Enter value: ");
                    int value = sc.nextInt();
                    System.out.print("Enter position: ");
                    int pos = sc.nextInt();
                    list.insertAtPosition(value, pos);
                    break;

                case 4:
                    System.out.print("Insert after which value? ");
                    int targetAfter = sc.nextInt();
                    System.out.print("Enter new value: ");
                    int valueAfter = sc.nextInt();
                    list.insertAfter(targetAfter, valueAfter);
                    break;

                case 5:
                    System.out.print("Insert before which value? ");
                    int targetBefore = sc.nextInt();
                    System.out.print("Enter new value: ");
                    int valueBefore = sc.nextInt();
                    list.insertBefore(targetBefore, valueBefore);
                    break;

                case 6:
                    list.deleteBeginning();
                    break;

                case 7:
                    list.deleteEnd();
                    break;

                case 8:
                    System.out.print("Enter position: ");
                    list.deleteAtPosition(sc.nextInt());
                    break;

                case 9:
                    System.out.print("Enter value to delete: ");
                    list.deleteByValue(sc.nextInt());
                    break;

                case 10:
                    System.out.print("Enter value to search: ");
                    list.search(sc.nextInt());
                    break;

                case 11:
                    System.out.print("Enter old value: ");
                    int oldValue = sc.nextInt();
                    System.out.print("Enter new value: ");
                    int newValue = sc.nextInt();
                    list.update(oldValue, newValue);
                    break;

                case 12:
                    list.displayForward();
                    break;

                case 13:
                    list.displayBackward();
                    break;

                case 14:
                    System.out.println("Total nodes: " + list.countNodes());
                    break;

                case 15:
                    list.findMaximum();
                    break;

                case 16:
                    list.findMinimum();
                    break;

                case 17:
                    list.findMiddle();
                    break;

                case 18:
                    list.reverse();
                    System.out.println("List reversed.");
                    break;

                case 19:
                    list.sort();
                    System.out.println("List sorted.");
                    break;

                case 20:
                    list.removeDuplicates();
                    System.out.println("Duplicates removed.");
                    break;

                case 21:
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 21);
    }

    // COMPARISON MENU
    static void compareLists() {

        System.out.println("\n--- SINGLY VS DOUBLY LINKED LIST ---");
        System.out.println("1. Singly Linked List");
        System.out.println("   Each node contains data and next.");
        System.out.println("   Traversal is forward only.");
        System.out.println("   Uses less memory per node.");

        System.out.println("\n2. Doubly Linked List");
        System.out.println("   Each node contains data, prev and next.");
        System.out.println("   Traversal is forward and backward.");
        System.out.println("   Uses more memory per node.");

        System.out.println("\nBoth support insertion and deletion.");
        System.out.println("Their time complexity depends on the operation.");
    }
}
