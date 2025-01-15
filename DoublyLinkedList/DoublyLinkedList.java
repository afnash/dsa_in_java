package DoublyLinkedList;
import java.util.*;

class DoublyLinkedList {
    class Node {
        int data;
        Node prev, next;

        Node(int data) {
            this.data = data;
            this.prev = this.next = null;
        }
    }

    private Node head, tail;

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void findAndDisplayUniqueTripletsWithSumZero() {
        Set<String> uniqueTriplets = new HashSet<>();
        Node ptr1 = head;

        while (ptr1 != null) {
            Node ptr2 = ptr1.next;
            while (ptr2 != null) {
                Node ptr3 = ptr2.next;
                while (ptr3 != null) {
                    if (ptr1.data + ptr2.data + ptr3.data == 0) {
                        int[] triplet = {ptr1.data, ptr2.data, ptr3.data};
                        Arrays.sort(triplet);
                        String tripletKey = triplet[0] + "," + triplet[1] + "," + triplet[2];
                        if (!uniqueTriplets.contains(tripletKey)) {
                            uniqueTriplets.add(tripletKey);
                            System.out.println("Unique Triplet: " + triplet[0] + ", " + triplet[1] + ", " + triplet[2]);
                        }
                    }
                    ptr3 = ptr3.next;
                }
                ptr2 = ptr2.next;
            }
            ptr1 = ptr1.next;
        }
    }

    public void deleteTripletsWithSumZero() {
        Set<String> uniqueTriplets = new HashSet<>();
        Node ptr1 = head;

        while (ptr1 != null) {
            Node ptr2 = ptr1.next;
            while (ptr2 != null) {
                Node ptr3 = ptr2.next;
                while (ptr3 != null) {
                    if (ptr1.data + ptr2.data + ptr3.data == 0) {
                        int[] triplet = {ptr1.data, ptr2.data, ptr3.data};
                        Arrays.sort(triplet);
                        String tripletKey = triplet[0] + "," + triplet[1] + "," + triplet[2];
                        if (!uniqueTriplets.contains(tripletKey)) {
                            uniqueTriplets.add(tripletKey);
                            delete(triplet[0], triplet[1], triplet[2]);
                            ptr1 = head; // Restart to ensure list consistency
                            break;
                        }
                    }
                    ptr3 = ptr3.next;
                }
                if (ptr1 == null) break;
                ptr2 = ptr2.next;
            }
            if (ptr1 == null) break;
            ptr1 = ptr1.next;
        }
    }

    private void delete(int... values) {
        for (int value : values) {
            Node current = head;
            while (current != null) {
                if (current.data == value) {
                    if (current.prev != null) {
                        current.prev.next = current.next;
                    } else {
                        head = current.next; // Update head
                    }
                    if (current.next != null) {
                        current.next.prev = current.prev;
                    } else {
                        tail = current.prev; // Update tail
                    }
                    break;
                }
                current = current.next;
            }
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter numbers for the list (type 'done' to finish):");
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                dll.add(scanner.nextInt());
            } else if (scanner.next().equalsIgnoreCase("done")) {
                break;
            } else {
                System.out.println("Invalid input. Please enter an integer or 'done'.");
            }
        }

        System.out.println("Original List:");
        dll.display();

        System.out.println("Finding and displaying unique triplets with sum 0:");
        dll.findAndDisplayUniqueTripletsWithSumZero();

        dll.deleteTripletsWithSumZero();

        System.out.println("List after removing triplets with sum 0:");
        dll.display();

        scanner.close();
    }
}
