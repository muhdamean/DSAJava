package list;

import java.util.NoSuchElementException;

public class Queue {
    private ListNode front;
    private ListNode rear;
    private int length;

    public Queue(){
        this.front=null;
        this.rear=null;
        this.length=0;
    }
    
    private class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data=data;
            this.next=null;
        }
    }

    public int lenght(){
        return length;
    }
    public boolean isEmpty(){
        return length==0;
    }

    //enqueue
    public void enqueue(int data){
        ListNode temp=new ListNode(data);
        if(isEmpty()){
            front=temp;
        }else{
            rear.next=temp;
        }
        rear=temp;
        length++;
    }

    //dequeue
    public int dequeue(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        int result=front.data;
        front=front.next;
        if(front==null){
            rear=null;
        }
        length--;
        return result;
    }

    //print queue
    public void print(){
        if(isEmpty()){
            return;
        }
        ListNode current=front;
        while(current!=null){
            System.out.print(current.data+ " --> ");
            current=current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Queue queue=new Queue();
        queue.enqueue(10);
        queue.enqueue(15);
        queue.enqueue(20);

        queue.print();

        System.out.println("After Dequeue:");
        queue.dequeue();
        queue.print();
    }
}
