package list;

import java.util.NoSuchElementException;

public class DoublyLinkedList {

    private ListNode head;
    private ListNode tail;
    private int length;
    
    private class ListNode {
        private int data;
        private ListNode next;
        private ListNode previous;
        
        public ListNode(int data){
            this.data=data;
        }
    }

    public DoublyLinkedList(){
        this.head=null;
        this.tail=null;
        this.length=0;
    }

    public boolean isEmpty(){
        return length==0; //head ==null
    }

    public int length(){
        return length;
    }

    //insert last
    public void insertLast(int value){
        ListNode newNode=new ListNode(value);
        if(isEmpty()){
            head=newNode;
        }
        else{
            tail.next=newNode;
        }
        newNode.previous=tail;
        tail=newNode;
        length++;
    }

    //insert first
    public void insertFirst(int value){
        ListNode newNode=new ListNode(value);
        if(isEmpty()){
            tail=newNode;
        }else{
            head.previous=newNode;
        }
        newNode.next=head;
        head=newNode;
        length++;
    }

    //print elements in DLL
    public void displayForward(){
        if(head==null){
            return;
        }
        ListNode temp=head;
        while(temp!=null){
            System.out.print(temp.data+ " -->  ");
            temp=temp.next;
        }
        System.out.println("null");
    }

    //print elements in DLL backward direction
    public void dispalyBackward(){
        if(tail==null){
            return;
        }
        ListNode temp=tail;
        while(temp!=null){
            System.out.print(temp.data+ " -->  ");
            temp=temp.previous;
        }
        System.out.println("null");
    }

    //delete first
    public ListNode deleteFirst(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        ListNode temp=head;
        if(head==tail){
            tail=null;
        }else{
            head.next.previous=null;
        }
        head=head.next;
        temp.next=null;
        return temp;
    }

    //delete last
    public ListNode deleteLast(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        ListNode temp=tail;
        if(head==tail){
            tail=null;
        }else{
            tail.previous.next=null;
        }
        tail=tail.previous;
        temp.previous=null;
        return temp;
    }

    public static void main(String[] args) {
        DoublyLinkedList dll=new DoublyLinkedList();

        dll.insertFirst(2);
        dll.insertFirst(4);
        dll.insertFirst(5);
        dll.insertFirst(8);

        dll.displayForward();
        dll.dispalyBackward();

        dll.deleteFirst();
        dll.displayForward();

        dll.deleteLast();
        dll.displayForward();
    }
}
