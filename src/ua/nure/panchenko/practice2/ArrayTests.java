package ua.nure.panchenko.practice2;

import java.util.Iterator;

public class ArrayTests {

	public static void main(String[] args) {
		test13();
	}

	private static void test1() {

		Array array = new ArrayImpl();
		Class c = array.getClass();

		// must be 1
		System.out.println(c.getInterfaces().length);

		// must be Array
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
		Array
		java.lang.Object
		1
		Container
		1
		java.lang.Iterable
		*************************************
		*/
	}

	private static void test2() {

		Array array = new ArrayImpl();
		array.add("A");
		array.add("B");
		array.add("C");

		System.out.println(array);
		System.out.println(array.size());

		array.clear();
		System.out.println(array);
		System.out.println(array.size());

		array.add("A");
		array.add("B");
		array.add("C");

		System.out.println(array);
		System.out.println(array.size());

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

		Array array = new ArrayImpl();
		array.add("A");
		array.add("B");
		array.add("C");

		array.set(1, "d");
		System.out.println(array);

		array.set(0, "b");
		System.out.println(array);

		/* an output must be as the following:
		*************************************
		[A, d, C]
		[b, d, C]
		*************************************
		*/
	}

	private static void test4() {

		Array array = new ArrayImpl();
		array.add("A");
		array.add("B");
		array.add("C");

		System.out.print(array.get(2));
		System.out.print(array.get(1));
		System.out.print(array.get(0));

		/* an output must be as the following:
		*************************************
		CBA
		*************************************
		*/
	}

	private static void test5() {

		Array array = new ArrayImpl();
		array.add("A");
		array.add("B");
		array.add("C");

		System.out.println(array.indexOf("A"));
		System.out.println(array.indexOf("B"));
		System.out.println(array.indexOf("C"));
		System.out.println(array.indexOf("D"));

		/* an output must be as the following:
		*************************************
		0
		1
		2
		-1
		*************************************
		*/
	}

	private static void test6() {

		Array array = new ArrayImpl();
		array.add("A");
		array.add("B");
		array.add("C");

		array.remove(2);
		System.out.println(array);

		array.remove(0);
		System.out.println(array);

		array.remove(0);
		System.out.println(array);

		/* an output must be as the following:
		*************************************
		[A, B]
		[B]
		[]
		*************************************
		*/
	}

	private static void test7() {

		Array array = new ArrayImpl();
		array.add("A");
		array.add("B");
		array.add("C");

		for (Object element : array) {
			System.out.print(element);
		}

		/* an output must be as the following:
		*************************************
		ABC
		*************************************
		*/
	}

	private static void test8() {

		Array array = new ArrayImpl();
		array.add("A");
		array.add("B");
		array.add("C");

		Iterator it = array.iterator();
		while (it.hasNext()) {
			System.out.print(it.next());
		}
		System.out.println();
		it = array.iterator();
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

	private static void test9() {

		Array array = new ArrayImpl();
		array.add("A");
		array.add("B");
		array.add("C");

		Iterator it = array.iterator();
		System.out.println(it.next());
		it.remove();
		System.out.println(it.next());
		it.remove();
		System.out.println(it.next());
		it.remove();
		System.out.println(array);

		/* an output must be as the following:
		*************************************
		A
		B
		C
		[]
		*************************************
		*/
	}

	private static void test10() {

		Array array = new ArrayImpl();
		array.add("A");
		array.add("B");
		array.add("C");

		Iterator it = array.iterator();

		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.next());
		it.remove();
		System.out.println(array);

		it = array.iterator();

		System.out.println(it.next());
		it.remove();
		System.out.println(array);

		it = array.iterator();

		System.out.println(it.next());
		it.remove();
		System.out.println(array);

		/* an output must be as the following:
		*************************************
		A
		B
		C
		[A, B]
		A
		[B]
		B
		[]
		*************************************
		*/
	}

	private static void test11() {

		Array array = new ArrayImpl();
		array.add("A");
		array.add("B");
		array.add("C");

		Iterator it = array.iterator();
		System.out.println(it.next());
		System.out.println(it.next());

		it = array.iterator();
		System.out.println(it.next());
		System.out.println(it.next());

		/* an output must be as the following:
		*************************************
		A
		B
		A
		B
		*************************************
		*/
	}

	private static void test12() {

		Array array = new ArrayImpl();
		array.add("A");
		array.add("B");
		array.add("C");

		Iterator it = array.iterator();
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

	private static void test13() {

		Array array = new ArrayImpl();
		array.add("A");
		array.add("B");
		array.add("C");

		Iterator it = array.iterator();
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

}
