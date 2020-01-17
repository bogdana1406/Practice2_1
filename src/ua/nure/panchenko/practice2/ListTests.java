package ua.nure.panchenko.practice2;

import java.util.Iterator;

public class ListTests {

	public static void main(String[] args) {
		test2();
	}

	private static void test1() {

		List list = new ListImpl();
		Class c = list.getClass();

		// must be 1
		System.out.println(c.getInterfaces().length);

		// must be List
		System.out.println(c.getInterfaces()[0].getSimpleName());

		// must be java.lang.Object
		System.out.println(c.getSuperclass().getName());

		// must be 1
		System.out.println(c.getInterfaces()[0].getInterfaces().length);

		// must be Container
		System.out.println(c.getInterfaces()[0].getInterfaces()[0].getSimpleName());

		// must be 1
		System.out.println(c.getInterfaces()[0].getInterfaces()[0].getInterfaces().length);

		// must be java.lang.Iterable
		System.out.println(c.getInterfaces()[0].getInterfaces()[0].getInterfaces()[0].getName());

		/* an output must be as the following:
		*************************************
		1
		List
		java.lang.Object
		1
		Container
		1
		java.lang.Iterable
		*************************************
		*/
	}

	private static void test2() {

		List list = new ListImpl();
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");

		System.out.println(list);
		System.out.println(list.size());

		list.clear();
		System.out.println(list);
		System.out.println(list.size());

		list.addLast("A");
		list.addLast("B");
		list.addLast("C");

		System.out.println(list);
		System.out.println(list.size());

		/* an output must be as the following:
		*************************************
		[A, B, C]
		3
		[]
		0
		[A, B, C]
		3
		*************************************
		*/
	}

	private static void test3() {

		List list = new ListImpl();
		list.addFirst("A");
		list.addLast("B");
		list.addFirst("C");

		System.out.println(list);
		System.out.print(list.getFirst());
		System.out.print(list.getLast());

		/* an output must be as the following:
		*************************************
		[C, A, B]
		CB
		*************************************
		*/
	}

	private static void test4() {

		List list = new ListImpl();
		list.addFirst("c");
		list.addFirst("b");
		list.addFirst("a");
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");

		System.out.println(list);

		/* an output must be as the following:
		*************************************
		[a, b, c, A, B, C]
		*************************************
		*/
	}

	private static void test5() {

		List list = new ListImpl();
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");

		for (Object element : list) {
			System.out.print(element);
		}

		/* an output must be as the following:
		*************************************
		ABC
		*************************************
		*/
	}

	private static void test6() {

		List list = new ListImpl();
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");

		Iterator it = list.iterator();
		while (it.hasNext()) {
			System.out.print(it.next());
		}
		System.out.println();
		it = list.iterator();
		while (it.hasNext()) {
			System.out.print(it.next());
		}

		/* an output must be as the following:
		*************************************
		ABC
		ABC
		*************************************
		*/
	}

	private static void test7() {

		List list = new ListImpl();
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");

		Iterator it = list.iterator();
		System.out.println(it.next());
		it.remove();
		System.out.println(it.next());
		it.remove();
		System.out.println(it.next());
		it.remove();
		System.out.println(list);

		/* an output must be as the following:
		*************************************
		A
		B
		C
		[]
		*************************************
		*/
	}

	private static void test8() {

		List list = new ListImpl();
		list.addLast("A");
		list.addFirst("B");
		list.addLast("C");

		Iterator it = list.iterator();

		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.next());
		it.remove();
		System.out.println(list);

		it = list.iterator();

		System.out.println(it.next());
		it.remove();
		System.out.println(list);

		it = list.iterator();

		System.out.println(it.next());
		it.remove();
		System.out.println(list);

		/* an output must be as the following:
		*************************************
		B
		A
		C
		[B, A]
		B
		[A]
		A
		[]
		*************************************
		*/
	}

	private static void test9() {

		List list = new ListImpl();
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");

		Iterator it = list.iterator();
		System.out.println(it.next());
		it.remove();
		try {
			it.remove();
		} catch (IllegalStateException ex) {
			System.out.println("exception");
		}

		/* an output must be as the following:
		*************************************
		A
		exception
		*************************************
		*/
	}

	private static void test10() {

		List list = new ListImpl();
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");

		Iterator it = list.iterator();
		try {
			it.remove();
		} catch (IllegalStateException ex) {
			System.out.println("exception");
		}

		/* an output must be as the following:
		*************************************
		exception
		*************************************
		*/
	}

	private static void test11() {

		List list = new ListImpl();
		list.addFirst("B");
		list.addLast("C");
		list.addFirst("A");

		System.out.println(list);

		list.removeFirst();
		System.out.println(list);

		list.removeFirst();
		System.out.println(list);

		/* an output must be as the following:
		*************************************
		[A, B, C]
		[B, C]
		[C]
		*************************************
		*/
	}

	private static void test12() {

		List list = new ListImpl();
		list.addFirst("B");
		list.addLast("C");
		list.addFirst("A");

		System.out.println(list);

		list.removeLast();
		System.out.println(list);

		list.removeLast();
		System.out.println(list);

		/* an output must be as the following:
		*************************************
		[A, B, C]
		[A, B]
		[A]
		*************************************
		*/
	}

	private static void test13() {

		List list = new ListImpl();
		list.addFirst("B");
		list.addLast("C");
		list.addFirst("A");

		System.out.println(list);
		System.out.println(list.getFirst());
		System.out.println(list.getLast());

		/* an output must be as the following:
		*************************************
		[A, B, C]
		A
		C
		*************************************
		*/
	}

	private static void test14() {

		List list = new ListImpl();
		list.addFirst(3);
		list.addFirst(2);
		list.addFirst(1);

		System.out.println(list);
		System.out.println(list.search(1));
		System.out.println(list.search(2));
		System.out.println(list.getLast());

		/* an output must be as the following:
		*************************************
		[1, 2, 3]
		1
		2
		3
		*************************************
		*/
	}

	private static void test15() {

		List list = new ListImpl();
		list.addLast(1);
		list.addLast(2);
		list.addLast(1);

		list.remove(1);
		System.out.println(list);

		list.remove(2);
		System.out.println(list);

		Iterator it = list.iterator();
		System.out.println(it.next());

		/* an output must be as the following:
		*************************************
		[2, 1]
		[1]
		1
		*************************************
		*/
	}

}
