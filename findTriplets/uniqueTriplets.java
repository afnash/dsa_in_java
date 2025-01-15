package findTriplets;
import java.util.*;
class Node{
    int data;
    Node next,prev;
    public Node(int d){
        data=d;
        next=prev=null;
    }
}
class DLL{
    public Node head,tail;
    public void insert(int value){
        Node newNode=new Node(value);
        if(head==null){
            head=tail=newNode;
        }else{
            tail.next=newNode;
            newNode.prev=tail;
            tail=newNode;
        }
    }
    public void UniqueTriplets(){
        Node p1=head;
        while(p1!=null){
           Node p2=p1.next;
            while(p2!=null){
               Node p3=p2.next;
               while(p3!=null){
                   if(p1.data+p2.data+p3.data==0){
                       if(!isDuplicate(p1,p2,p3)){
                           System.out.println("Unique triplet: "+p1.data+","+p2.data+","+p3.data);
                       }
                   }
                   p3=p3.next;
               } p2=p2.next;
            }p1=p1.next;
        }
    }
    public boolean isDuplicate(Node p1,Node p2,Node p3){
        Node check1=head;
        while(check1!=null){
            Node check2=check1.next;
            while(check2!=null){
                Node check3=check2.next;
                while(check3!=null){
                    if(check1.data==p1.data&&check2.data==p2.data&&check3.data==p3.data){
                        return false;
                    }
                        if(check1.data+check2.data+check3.data==0){
                            if((check1.data==p1.data&&check2.data==p2.data&&check3.data==p3.data)||(check1.data==p2.data&&check2.data==p3.data&&check3.data==p3.data)||(check1.data==p3.data&&check2.data==p1.data&&check3.data==p2.data)){
                                return true;
                            }
                            
                        
                }check3=check3.next;
            }check2=check2.next;
        }check1=check1.next;
    }return false;
    }
    public void display(){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }System.out.println();
    }
}
class UniqueTriplets{
    public static void main(String[] args) {
    DLL dll=new DLL();
    Scanner sc= new Scanner(System.in);
    System.out.println("Enter the no. of elements");
    int n= sc.nextInt();
    System.out.println("Enter the elements");
    for(int i=0;i<n;i++){
        int val=sc.nextInt();
        dll.insert(val);
    }
    System.out.println("OG list:");
    dll.display();
    System.out.println("Unique triplets are: ");
        dll.UniqueTriplets();
    sc.close();
}
    
}
