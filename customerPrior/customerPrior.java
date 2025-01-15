package customerPrior;

import java.util.*;

class Node {
    String name;
    String type;
    int waitingTime;
    Node next;

    public Node(String n, String t, int wait) {
        name = n;
        type = t;
        waitingTime = wait;
        next = null;
    }
}

class CustomerQueue {
    Node head;

    // Enqueue method
    public void enqueue(String name, String type, int time) {
        Node newNode = new Node(name, type, time);

        if (head == null || type.equals("Premium") ) {
            newNode.next = head; // Add new node at the front
            head = newNode;
        } else {
            Node curr = head;
            while (curr.next != null&& curr.next.type.equals("Local")) {
                curr = curr.next; // Find the correct position for Local customers
            }
            newNode.next = curr.next;
            curr.next = newNode;
        }
    }

    // Dequeue method
    public void dequeue() {
        if (head == null) {
            System.out.println("Nothing in Queue");
        } else {
            String temp = head.name;
            head = head.next; // Remove the head
            System.out.println("Service done for: " + temp);
        }
    }

    // Display method
    public void display() {
        if (head == null) {
            System.out.println("Nothing in Queue");
        } else {
            Node curr = head;
            while (curr != null) {
                System.out.println(curr.name + " is a " + curr.type + " customer, waiting time: " + curr.waitingTime);
                curr = curr.next;
            }
        }
    }

    // Calculate waiting time for a specific customer
    public void calculateTime(String customerName) {
        int waitTime = 0;
        Node curr = head;
        boolean found = false;

        while (curr != null) {
            if (curr.name.equals(customerName)) {
                System.out.println("Waiting time for " + customerName + " is: " + waitTime);
                found = true;
                break;
            }
            waitTime += curr.waitingTime;
            curr = curr.next;
        }

        if (!found) {
            System.out.println("No customer found with name: " + customerName);
        }
    }
}

public class customerPrior {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CustomerQueue queue = new CustomerQueue();
        boolean running = true;

        while (running) {
            System.out.println("\nEnter a choice:");
            System.out.println("1. Enqueue \n2. Dequeue \n3. Check service time \n4. Display \n5. Exit");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter customer name:");
                    String name = sc.nextLine();
                    System.out.println("Enter customer type (Premium/Local):");
                    String type = sc.nextLine();
                    System.out.println("Enter service time:");
                    int time = sc.nextInt();
                    queue.enqueue(name, type, time);
                    break;

                case 2:
                    queue.dequeue();
                    break;

                case 3:
                    System.out.println("Enter customer name:");
                    String customerName = sc.nextLine();
                    queue.calculateTime(customerName);
                    break;

                case 4:
                    queue.display();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        sc.close();
    }
}
