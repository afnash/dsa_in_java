package delNthFromBack;
import java.util.*;
class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}
class process{
    Node head;
    public void insert(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
        }else{
            Node curr=head;
            while(curr.next !=null){
                curr=curr.next;
            }
            curr.next=newNode;
        }
    }

public void delete(int n, int length){
Node curr=head;
while(curr.next!=null){
    curr=curr.next;
}
int target=length-n+1;

if(target==1){
    head=head.next;
}else{
    curr=head;
    for(int i=1;i<target-1;i++){
        curr=curr.next;
    }
    curr.next=curr.next.next;}
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

public class delFromBack {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        process list= new process();
        System.out.println("Enter the no. of elements");
        int length=sc.nextInt();
        System.out.println("Enter the elements");
        for(int i=0;i<length;i++){
            int value=sc.nextInt();
            list.insert(value);
        }
        System.out.println("Current list: ");
        list.display();
        System.out.println("enter node from back to delete");
        int n=sc.nextInt();
        list.delete(n,length);
        System.out.println("updated list: ");
        list.display();   
        sc.close();     
    } 

    
}
