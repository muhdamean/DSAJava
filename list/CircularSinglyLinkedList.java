package list;

import java.util.NoSuchElementException;

public class CircularSinglyLinkedList {
    private ListNode last;
    private int length;

    private class ListNode{
        private int data;
        private ListNode next;

        private ListNode(int data){
            this.data=data;
        }
    }

    public CircularSinglyLinkedList(){
        last=null;
        length=0;
    }

    public int length(){
        return length;
    }

    public boolean isEmpty(){
        return length==0;
    }

    //create CSLL
    public void createCircularLinkedList(){
        ListNode first=new ListNode(1);
        ListNode second=new ListNode(5);
        ListNode third=new ListNode(10);
        ListNode fourth=new ListNode(15);

        first.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=first;

        last=fourth;
    }

    public void display(){
        if(last==null){
            return;
        }

        ListNode first=last.next;
        while(first!=last){
            System.out.print(first.data+ " ");
            first=first.next;
        }
        System.out.print(first.data+" ");
        System.out.println();
    }

    //insert first
    public void insertFirst(int data){
        ListNode temp=new ListNode(data);
        if(last==null){
            last=temp;
        }
        else{
            temp.next=last.next;
        }
        last.next=temp;
        length++;
    }

    //insert last
    public void insertLast(int data){
        ListNode temp=new ListNode(data);
        if(last==null){
            last=temp;
            last.next=last;
        }else{
            temp.next=last.next;
            last.next=temp;
            last=temp;
        }
        length++;
    }

    //remove first node
    public int removeFirst(){
        if(isEmpty()){
            throw new NoSuchElementException("Circular Singly Linked List is already empty");
        }
        ListNode temp=last.next;
        int result=temp.data;
        if(last.next==last){
            last=null;
        }
        else{
            last.next=temp.next;
        }
        //temp.next=null;
        length--;
        return result;
    }
    public static void main(String[] args) {
        CircularSinglyLinkedList csll=new CircularSinglyLinkedList();

        //csll.createCircularLinkedList();

        csll.insertLast(1);
        csll.insertLast(5);
        csll.insertLast(8);
        csll.insertLast(15);

        csll.display();

        csll.insertFirst(7);
        csll.display();

        csll.insertLast(9);
        csll.display();

         
        System.out.println(csll.removeFirst());
        csll.display();
    }

}
