package APQue;
import java.util.*;

class Node {
    int data;
    Node next;

    public Node(int d) {
        data = d;
        next = null;
    }
}

class APQueue {
    Node front;

    public APQueue() {
        front = null;
    }

    public void enqueue(int d) {
        Node newNode = new Node(d);
        if (front == null || front.data >= d) {
            newNode.next = front;
            front = newNode;
        } else {
            Node curr = front;
            while (curr.next != null && curr.next.data < d) {
                curr = curr.next;
            }
            newNode.next = curr.next;
            curr.next = newNode;
        }
        System.out.println("Inserted " + d);
    }

    public void dequeue() {
        if (!isEmpty()) {
            int temp = front.data;
            front = front.next;
            System.out.println(temp + " is deleted from queue.");
        } else {
            System.out.println("Empty queue. Cannot operate dequeue.");
        }
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void display() {
        Node curr = front;
        if (isEmpty()) {
            System.out.println("Empty queue.");
            return;
        }
        System.out.println("Queue elements:");
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println(); // For formatting
    }
}

public class AscPriorQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        APQueue apq = new APQueue();
        boolean running = true;
        while (running) {
            System.out.println("Enter any key from the Menu:");
            System.out.println("1: Enqueue \n2: Dequeue \n3: Display \n4: Check Empty \n5: Exit");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter the value to insert");
                    int value = sc.nextInt();
                    apq.enqueue(value);
                    break;
                case 2:
                    apq.dequeue();
                    break;
                case 3:
                    apq.display();
                    break;
                case 4:
                    System.out.println(apq.isEmpty() ? "Queue is empty." : "Queue is not empty.");
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Enter a valid key");
            }
        }
        sc.close();
    }
}
