package ua.nure.panchenko.practice2;

import java.util.Iterator;

public class Demo {
    public static void main(String[] args) {
        System.out.println("Array");
        Array array = new ArrayImpl();
        array.add("A");
        array.add("B");
//        array.add("C");

        Iterator it = array.iterator();
        while (it.hasNext()) {
            System.out.print(it.next());
        }
        System.out.println();
        it = array.iterator();
        while (it.hasNext()) {
            System.out.print(it.next());
        }

        System.out.println("\n\nList");
        ListImpl list = new ListImpl();
        list.addFirst("p");
        list.addFirst("a");
        list.addFirst("e");
        list.addFirst("h");
        System.out.println(list);

        list.removeLast();
        list.removeLast();
        System.out.println(list);

        list.addLast("s");
        Iterator itr = list.iterator();
        while(itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }

        System.out.println("\n\nQueue");
        QueueImpl queue = new QueueImpl();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
//        queue.enqueue("d");
        Iterator itQ = queue.iterator();
        System.out.println(itQ.next());

        System.out.println("\n\nStack");
        StackImpl stack = new StackImpl();
        stack.push("a");
        Iterator itS = stack.iterator();
        System.out.println(itS.next());
    }
}
