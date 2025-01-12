import java.util.*;
class Node {
    int exp;
    int coeff;
    Node next;

    public Node(int c, int e) {
        coeff = c;
        exp = e;
        next = null;
    }
}

class SlList {
    Node head;

    public SlList() {
        head = null;
    }

    public void addTerm(int coeff, int exp) {
        Node newNode = new Node(coeff, exp);
        if (head == null) {
            head = newNode;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }

    }

    public void display() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.coeff + "x^" + curr.exp + "+");
            curr = curr.next;
        }
        System.out.println();
    }
}
public class AddPoly{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the number of terms of first polynomial");
        int n1= sc.nextInt();
        SlList p1= new SlList();
        for(int i=1;i<=n1;i++){
            System.out.println("enter term "+i+" coefficient");
            int coeff=sc.nextInt();
            System.out.println("enter term "+i+" exponent");
            int exp=sc.nextInt();
            p1.addTerm(coeff, exp);
        }
        System.out.println("Enter the number of terms of second polynomial");
        int n2= sc.nextInt();
        SlList p2= new SlList();
        for(int i=1;i<=n2;i++){
            System.out.println("enter term "+i+" coefficient");
            int coeff=sc.nextInt();
            System.out.println("enter term "+i+" exponent");
            int exp=sc.nextInt();
            p2.addTerm(coeff, exp);
        }
        System.out.println("Polynomial 1:");
        p1.display();
        System.out.println("Polynomial 2:");
        p2.display();
        SlList res= addPol(p1,p2);
        System.out.println("resultant");
        res.display();
        sc.close();
    }
    public static SlList addPol(SlList p1,SlList p2){
    SlList res= new SlList();
    Node curr1= p1.head;
    Node curr2= p2.head;
    while (curr1!=null&&curr2!=null) {
            if(curr1.exp==curr2.exp){
                res.addTerm(curr1.coeff+curr2.coeff,curr1.exp);
                curr1=curr1.next;
                curr2=curr2.next;
            }else if(curr1.exp>curr2.exp){
                res.addTerm(curr1.coeff,curr1.exp);
                curr1=curr1.next;
            
            }else{
                res.addTerm(curr2.coeff,curr2.exp);
                curr2=curr2.next;
            }
        
    }
    while (curr1!=null) {
        res.addTerm(curr1.coeff,curr1.exp);
        curr1=curr1.next;
    }
    while (curr2!=null) {
        res.addTerm(curr2.coeff,curr2.exp);
        curr2=curr2.next;
    }
    return res;
    }
}