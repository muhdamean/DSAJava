package list;

import java.util.EmptyStackException;

public class Stack {
    private ListNode top;
    private int lenght;

    private class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data=data;
        }
    }

    public Stack(){
        top=null;
        lenght=0;
    }

    public boolean isEmpty(){
        return lenght==0;
    }

    public void push(int data){
        ListNode temp=new ListNode(data);
        temp.next=top;
        top=temp;
        lenght++;
    }

    public int pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        int result =top.data;
        top=top.next;
        lenght--;
        return result;
    }

    public int peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return top.data;
    }

    public static void main(String[] args) {
        Stack stack=new Stack();
        stack.push(10);
        stack.push(15);
        stack.push(20);

        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
    }
}
