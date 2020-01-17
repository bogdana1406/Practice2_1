package ua.nure.panchenko.practice2;

import java.util.Iterator;

import java.util.NoSuchElementException;

public class ListImpl implements List {

    private Node head;

    public ListImpl()
    {
        head = null;
    }

    @Override
    public void addFirst(Object element)
    {
        head = new Node(element, head);
    }

    @Override
    public void addLast(Object element) {
        if( head == null) {
            addFirst(element);
        } else {
            Node tmp = head;
            while(tmp.next != null) tmp = tmp.next;
            tmp.next = new Node(element, null);
        }
    }

    @Override
    public void removeFirst() {
        head = head.next;
    }

    @Override
    public void removeLast() {
        if(head == null) {
            throw new NoSuchElementException();
        }
        Node tmp = head;
        Node prev = null;
        while(tmp.next != null) {
            prev = tmp;
            tmp = tmp.next;
        }

        if (prev == null) {
            throw new NullPointerException();
        }
         prev.next = null;
    }

    @Override
    public Object getFirst() {
        if(head == null) throw new NoSuchElementException();
        return head.data;
    }

    @Override
    public Object getLast() {
        if(head == null) throw new NoSuchElementException();
        Node tmp = head;
        while(tmp.next != null) tmp = tmp.next;
        return tmp.data;
    }

    @Override
    public Object search(Object element) {
        Object find = null;
        for(Object tmp : this)
            if(tmp.equals(element)) {
                find = element;
            }
        return find;
    }

    @Override
    public boolean remove(Object element) {
        boolean canRemove;
        if(head == null) {
            throw new NoSuchElementException();
        }
        if( head.data.equals(element) ) {
            head = head.next;
            canRemove = true;
        } else {
            Node cur  = head;
            Node prev = null;
            while(cur != null && !cur.data.equals(element) ) {
                prev = cur;
                cur = cur.next;
            }
            if(cur == null) {
                canRemove = false;
            } else {
                if (prev == null) {
                    throw new NullPointerException();
                }
                prev.next = cur.next;
                canRemove = true;
            }
        }
        return canRemove;
    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public int size() {
        int size = 0;
        for(Object x : this) {
            size++;
        }
        return size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for(Object x : this) {
            if (x != getLast()) {
                result.append(x + ", ");
            } else {
                result.append(x);
            }
        }
        result.append("]");

        return result.toString();
    }


//  Node class
    private static class Node {
        private Object data;
        private Node next;

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

//  Iterator class
    public Iterator iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator  implements Iterator {
        private Node nextNode;
        private Object next;
        boolean canBeRemoved;

        public LinkedListIterator()
        {
            nextNode = head;
        }

        @Override
        public boolean hasNext()
        {
            return nextNode != null;
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Object res = nextNode.data;
            nextNode = nextNode.next;
            canBeRemoved = true;
            this.next = res;
            return res;
        }

        @Override
        public void remove() {
            if (!canBeRemoved) {
                throw new IllegalStateException();
            }
            if( head.data.equals(next) ) {
                head = head.next;
                return;
            }

            Node cur  = head;
            Node prev = null;
            while(cur != null && !cur.data.equals(next) ) {
                prev = cur;
                cur = cur.next;
            }

            if(cur == null) {
                throw new IllegalStateException();
            }
            if (prev == null) {
                throw new NullPointerException();
            }
            prev.next = cur.next;
            canBeRemoved = false;
        }
    }
}
