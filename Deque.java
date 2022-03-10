import java.util.*;

public class Deque<Item> implements Iterable<Item> {
    public Node first,last;
    int n;
    private class Node{
        Item data;
        Node Next;
    }

    // construct an empty deque
    public Deque(){
        first=null;
        last=null;
        n=0;
    }

    // is the deque empty?
    public boolean isEmpty(){
        if (first ==null && last == null){
            return true;
        }
        else{
            return false;
        }
    }

    // return the number of items on the deque
    public int size(){
        return n;
    }

    // add the item to the front
    public void addFirst(Item item){
        if (item == null) throw new IllegalArgumentException();
        Node old = first;
        first = new Node();
        first.data= item;
        first.Next = old;
        n=n+1;
    }

    // add the item to the back
    public void addLast(Item item){
        if (item== null) throw new IllegalArgumentException();
        Node old= last;
        last = new Node();
        last.data= item;
        old.Next= last;
        n=n+1;
    }

    // remove and return the item from the front
    public Item removeFirst(){
        if (n==0) throw new NoSuchElementException();
        Item item = first.data;
        first= first.Next;
        n=n-1;
        return item;
    }

    // remove and return the item from the back
    public Item removeLast(){
        if (n==0) throw new NoSuchElementException();
        if (first.Next== null){
            Item item1 = first.data;
            last=null;
            first=null;
            n=n-1;
            return item1;
        }
        else{
            Node temp= first;
            while (temp.Next != last){
                temp=temp.Next;
            }
            last= temp;
            n=n-1;
            return last.data;

        }
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator(){
        return new hasIterator();
    }
    public class hasIterator implements Iterator<Item>{
        Node temp = first;
        public boolean hasNext(){ 
            return temp != null; 
        }
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item1 = temp.data;
            temp = temp.Next;
            return item1;
        }
        public void remove() {
            throw new UnsupportedOperationException(); } 
    }


    // unit testing (required)
    public static void main(String[] args){
        Deque Deque1 = new Deque();
        Deque1.addFirst("Sree");
        Deque1.addFirst("Charan");
        System.out.println(Deque1.isEmpty());
        System.out.println(Deque1.size());
        System.out.println(Deque1.removeLast());
        System.out.print(Deque1.size());


}


}

