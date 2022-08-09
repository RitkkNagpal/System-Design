package LinkedListIterator;
import java.util.Iterator;
import java.lang.Iterable;
public class LinkedListPrac{
    static class MyList implements Iterable<Integer>{
        static class Node{
            int data;
            Node next;
            Node(){

            }
            Node(int data,Node next){
                this.data = data;
                this.next = next;
            }
        }

        Node head,tail;
        int size;

        public MyList(){
            head = null;
            tail = null;
            size = 0;
        }

        public void addLast(int val){
            Node nn = new Node(val,null);
            if(size == 0){
                head = tail = nn;
            }
            else{
                tail = tail.next = nn;
            }
            size++;
        }

        public Iterator<Integer>iterator(){
            return new MyListIterator(head);
        }

        public static class MyListIterator implements Iterator<Integer>{
            Node temp;
            MyListIterator(Node temp){
                this.temp = temp;
            }

            public boolean hasNext(){
                if(temp == null){
                    return false;
                }
                return true;
            }

            public Integer next(){
                int rv = temp.data;
                temp = temp.next;
                return rv;
            }
        }
    }

    public static void main(String[] args) {
        MyList list = new MyList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);

        for (int val : list) {
            System.out.print(val + " -> ");
        }
    }
}