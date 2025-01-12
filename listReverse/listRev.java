package listReverse;
import java.util.*;
class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}
class reverselist{
    Node head;
    public void insert(int data){
        Node newNode = new Node(data);
        if(head==null){
            head=newNode;
        }else{
            Node curr=head;
            while(curr.next!=null){
                curr=curr.next;
            }
            curr.next=newNode;
        }
    }
    public void reverse(){
        Node prev=null;
        Node curr=head;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }
    public void display(){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
        System.out.println();
    }
}
class listRev{
    public static void main(String[] args){
        reverselist list= new reverselist();
        Scanner sc= new Scanner(System.in);
        System.out.println("enter the no. of elements: ");
        int n= sc.nextInt();
        System.out.println("enter the elements");
        for(int i=0;i<n;i++){
            int value=sc.nextInt();
            list.insert(value);
        }
        System.out.println("Original elements:");
        list.display();

        list.reverse();
        System.out.println("reversed elements:");
        list.display();    
        sc.close();   
    }
}