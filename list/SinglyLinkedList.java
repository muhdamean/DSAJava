package list;

public class SinglyLinkedList{
    private ListNode head;

    private static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data=data;
            this.next=null;
        }
    }
    //print the singly linked list with parameter
    public void display(ListNode head){
        ListNode current=head;
        while(current!=null){
            System.out.print(current.data+" --> ");
            current=current.next;
        }
        System.out.println();
    }
    //print linkedlist
    public void printLinkedList(){
        ListNode current=null;
        current=head;
        while(current!=null){
            System.out.print(current.data+" --> ");
            current=current.next;
        }
        System.out.println();
    }
    //count list
    public int length(){
        if(head==null){
            return 0;
        }
        int count=0;
        ListNode current=head;
        while(current!=null){
            count++;
            current=current.next;
        }
        return count;
    }
    //insert at Begining
    public void insertAtBegining(int value){
        ListNode newNode=new ListNode(value);
        if(head==null){
            head=newNode;
            return;
        }
        ListNode current=head;
        head=newNode;
        head.next=current;
    }
    //insert new node at head
    public void insertFirst(int value){
        ListNode newNode=new ListNode(value);
        newNode.next=head;
        head=newNode;
    }
    //insert node at the end of list
    public void insertLast(int value){
        ListNode newNode=new ListNode(value);
        if(head==null){
            head=newNode;
            return;
        }
        ListNode current=head;
        while(null!=current.next){
            current=current.next;
        }
        current.next=newNode;
    }
    //insert at a given position
    public void insert(int position, int value){
        ListNode node= new ListNode(value);
        if(position==1){
            node.next=head;
            head=node;
        }
        else{
            ListNode previous=head;
            int count=1;
            while(count < position-1){
                previous=previous.next;
                count++;
            }
            ListNode current=previous.next;
            previous.next=node;
            node.next=current;
        }
    }
    //delete firstNode
    public ListNode deleteFirst(){
        if(head==null){
            return null;
        }
        ListNode temp=head;
        head=head.next;
        temp.next=null;
        return  temp;
    }
    //delete lastNode
    public ListNode deleteLast(){
        if(head==null || head.next==null){
            return head;
        }
        ListNode current=head;
        ListNode previous=null;
        while(current.next!=null){
            previous=current;
            current=current.next;
        }
        previous.next=null;
        return current;
    }
    //delete at a given position
    public void delete(int position){
        if(position==1){
            head=head.next;
        }else{
            ListNode previous=head;
            int count=1;
            while(count<position-1){
                previous=previous.next;
                count++;
            }
            ListNode current=previous.next;
            previous.next=current.next;
        }   
    }
    //search a list
    public boolean find(ListNode head,int searchKey){
        if(head==null){
            return false;
        }
        ListNode current=head;
        while(current!=null){
            if(current.data==searchKey){
                return true;
            }
            current=current.next;
        }
        return false;
    }
    //reverse a list
    public ListNode reverse(ListNode head){
        if(head==null){
            return head;
        }
        ListNode current=head;
        ListNode previous=null;
        ListNode next=null;

        while(current!=null){
            next=current.next; //5 - 6 - 7 - 8   n=6, n=7, n=8
            current.next=previous; //cn=null cn=5  // 5 <-- 6 <-- 7
            previous=current; //p=5 p=6 p=7
            current=next;//c=6 c=7 c=8
        }
        return previous;
    }
    //find the middle node
    public ListNode getMiddleNode(ListNode head){
        if(head==null){
            return head;
        }
        ListNode slowPtr=head;
        ListNode fastPtr=head;
        while(fastPtr!=null && fastPtr.next!=null){
            slowPtr=slowPtr.next;
            fastPtr=fastPtr.next.next;
        }
        return slowPtr;
    }
    //find nth node from end of the list
    public ListNode nthNodeFromEnd(int n){
        if(head==null){
            return null;
        }
        if(n<=0){
            throw new IllegalArgumentException("Invalid value: n = "+n);
        }
        ListNode mainPtr=head;
        ListNode refPtr=head;
        int count=0;
        while(count<n){
            refPtr=refPtr.next;
            count++;
        }
        while(refPtr!=null){
            refPtr=refPtr.next;
            mainPtr=mainPtr.next;
        }
        return mainPtr;
    }

    //remove duplicate from list
    public void removeDuplicates(){
        if(head==null){
            return;
        }
        ListNode current=head;
        while(current!=null && current.next!=null){
            if(current.data==current.next.data){
                current.next=current.next.next;
            }else{
                current=current.next;
            }
        }
        
    }

    //insert in a sorted list
    public ListNode insertInSortedList(int value){
        ListNode newNode=new ListNode(value);
        if(head==null){
            head=newNode;
            return head;
        }
        ListNode current=head;
        ListNode temp=null;
        while(current!=null && current.data<newNode.data){
            temp=current;
            current=current.next;
        }
        newNode.next=current;
        temp.next=newNode;
        return head;
    }

    //remove node from list
    public void deleteNode(int key){
        ListNode current=head;
        ListNode temp=null;
        if(current!=null && current.data==key){
            head=current.next;
            return;
        }

        while(current!=null && current.data!=key){
            temp=current;
            current=current.next;
        }
        if(current==null) return;
        temp.next=current.next;
    }

    //detect loop in list
    public boolean containsLoop(){
        ListNode fastPtr=head;
        ListNode slowPtr=head;
        while(fastPtr!=null && fastPtr.next!=null){
            fastPtr=fastPtr.next.next;
            slowPtr=slowPtr.next;
            if(slowPtr==fastPtr){
                return true;
            }
        }
        return false;
    }
    //create a loop
    public void createALoopInLinkedList(){
        ListNode first=new ListNode(1);
        ListNode second=new ListNode(2);
        ListNode third=new ListNode(3);
        ListNode fourth=new ListNode(4);
        ListNode fifth=new ListNode(5);
        ListNode sixth=new ListNode(6);

        head=first;
        first.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=fifth;
        fifth.next=sixth;
        sixth.next=third;
    }
    
    //get start of a loop
    public ListNode startOfLoop(){
        ListNode fastPtr=head;
        ListNode slowPtr=head;
        while(fastPtr!=null && fastPtr.next!=null){
            fastPtr=fastPtr.next.next;
            slowPtr=slowPtr.next;
            if(slowPtr==fastPtr){
                return slowPtr;
            }
        }
        return slowPtr;
    }
    public ListNode getStartingNode(ListNode slowPtr){
        ListNode temp=head;
        while(slowPtr!=temp){
            temp=temp.next;
            slowPtr=slowPtr.next;
        }
        return temp;
    }
    //get start of a loop
     //detect loop in list
     public ListNode startNodeInALoop(){
        ListNode fastPtr=head;
        ListNode slowPtr=head;
        while(fastPtr!=null && fastPtr.next!=null){
            fastPtr=fastPtr.next.next;
            slowPtr=slowPtr.next;
            if(slowPtr==fastPtr){
                return getStartingNode(slowPtr);
            }
        }
        return null;
    }
    //remove loop from list
    public ListNode removeLoop(){
        ListNode fastPtr=head;
        ListNode slowPtr=head;
        while(fastPtr!=null && fastPtr.next!=null){
            fastPtr=fastPtr.next.next;
            slowPtr=slowPtr.next;
            if(slowPtr==fastPtr){
                removeLoop(slowPtr);
            }
        }
        return slowPtr;
    }
    //remove detected node from loop
    private void removeLoop(ListNode slowPtr){
        ListNode temp=head;
        while(slowPtr.next!=temp.next){
            temp=temp.next;
            slowPtr=slowPtr.next;
        }
        slowPtr.next= null;
    }
    //merge two list
    public static ListNode merge(ListNode a, ListNode b){
        ListNode dummy=new ListNode(0);
        ListNode tail=dummy;
        while(a!=null && b!=null){
            if(a.data<=b.data){
                tail.next=a;
                a=a.next;
            }else{
                tail.next=b;
                b=b.next;
            }
            tail=tail.next;
        }

        if(a==null){
            tail.next=b;
        }else{
            tail.next=a;
        }
        return dummy.next;
    }
    //add two list
    public static ListNode add(ListNode a, ListNode b){
        ListNode dummy=new ListNode(0);
        ListNode tail=dummy;
        int carry=0;
        while(a!=null && b!=null) {
            int x=(a!=null) ? a.data :0;
            int y=(a!=null) ? b.data :0;
            int sum=carry+x+y;
            tail.next=new ListNode(sum % 10);
            tail=tail.next;
            if(a!=null) a=a.next;
            if(b!=null) b=b.next;
        }
        if(carry>0){
            tail.next=new ListNode(carry);
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        SinglyLinkedList sll= new SinglyLinkedList();
        // sll.insertAtBegining(6);
        // sll.insertAtBegining(4);
        // sll.insertAtBegining(2);
        // sll.insertAtBegining(2);
        // sll.insertAtBegining(1);


        // ListNode head=new ListNode(8);
        // ListNode second=new ListNode(6);
        // ListNode third=new ListNode(3);
        // ListNode fourth=new ListNode(11);

        // head.next=second;
        // second.next=third;
        // third.next=fourth;
        // fourth.next=null;

        // sll.insertFirst(2); //insert at position 1
        // sll.insertLast(7);
        // sll.insert(1,5); //override the first value at position 1
        // sll.insert(4, 4);
       // System.out.println(sll.deleteFirst().data);//print the deleted first node
       // System.out.println(sll.deleteLast().data);//print the deleted first node
       //sll.delete(3);

       //sll.display(head);
       // System.out.println("Length is: "+sll.length());

        //ListNode reversListHead= sll.reverse(head);
        //sll.display(reversListHead);

        //ListNode middleNode=sll.getMiddleNode(head);
        //System.out.println("Middle node is - "+middleNode.data);

        //ListNode nthNodeFromEnd=sll.nthNodeFromEnd(2);
        //System.out.println("Nth node from end is - "+ nthNodeFromEnd.data);

        // sll.printLinkedList();
        // sll.removeDuplicates();
        // sll.printLinkedList();

        //insert in sorted lis
        // sll.insertInSortedList(5);
        // sll.printLinkedList();

        //delete node
        //sll.deleteNode(4);
        //sll.printLinkedList();

        //contains loop
        // sll.createALoopInLinkedList();
        // System.out.println(sll.containsLoop());
        // System.out.println(sll.startNodeInALoop().data);
        // sll.removeLoop();
        // sll.printLinkedList();

        //merge two list
        sll.insertLast(1);
        sll.insertLast(4);
        sll.insertLast(8);

        SinglyLinkedList sll2=new SinglyLinkedList();
        sll2.insertLast(3);
        sll2.insertLast(5);
        sll2.insertLast(6);
        sll2.insertLast(9);
        sll2.insertLast(14);
        sll2.insertLast(18);

        // sll.printLinkedList();
        // sll2.printLinkedList();

        SinglyLinkedList result=new SinglyLinkedList();
        // result.head=merge(sll.head, sll2.head);
        // result.printLinkedList();

        //add two list
        result.head=add(sll.head, sll2.head);
        result.printLinkedList();

        //search list
        // if(sll.find(head, 2)){
        //     System.out.println("Search key found !!!");
        // }else{
        //     System.out.println("Search key not found !!!");
        // }
    }
}