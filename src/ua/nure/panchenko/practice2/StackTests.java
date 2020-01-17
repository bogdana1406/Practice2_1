package ua.nure.panchenko.practice2;

import java.util.Iterator;

public class StackTests {

	public static void main(String[] args) {
		test10();
	}

	private static void test1() {

		Stack stack = new StackImpl();
		Class c = stack.getClass();

		// must be 1
		System.out.println(c.getInterfaces().length);

		// must be Stack
		System.out.println(c.getInterfaces()[0].getSimpleName());

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
		Stack
		1
		Container
		1
		java.lang.Iterable
		*************************************
		*/
	}

	private static void test2() {

		Stack stack = new StackImpl();
		stack.push("A");
		stack.push("B");
		stack.push("C");

		System.out.println(stack);
		System.out.println(stack.size());

		stack.clear();
		System.out.println(stack);
		System.out.println(stack.size());

		stack.push("A");
		stack.push("B");
		stack.push("C");

		System.out.println(stack);
		System.out.println(stack.size());

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

		Stack stack = new StackImpl();
		stack.push("A");
		stack.push("B");
		stack.push("C");

		System.out.print(stack.pop());
		System.out.print(stack.pop());
		System.out.print(stack.pop());

		/* an output must be as the following:
		*************************************
		CBA
		*************************************
		*/
	}

	private static void test4() {

		Stack stack = new StackImpl();
		stack.push("A");
		stack.push("B");
		stack.push("C");

		for (Object element : stack) {
			System.out.print(element);
		}

		/* an output must be as the following:
		*************************************
		CBA
		*************************************
		*/
	}

	private static void test5() {

		Stack stack = new StackImpl();
		stack.push("A");
		stack.push("B");
		stack.push("C");

		Iterator it = stack.iterator();
		while (it.hasNext()) {
			System.out.print(it.next());
		}
		System.out.println();
		it = stack.iterator();
		while (it.hasNext()) {
			System.out.print(it.next());
		}

		/* an output must be as the following:
		*************************************
		CBA
		CBA
		*************************************
		*/
	}

	private static void test6() {

		Stack stack = new StackImpl();
		stack.push("A");
		stack.push("B");
		stack.push("C");

		Iterator it = stack.iterator();
		System.out.println(it.next());
		it.remove();
		System.out.println(it.next());
		it.remove();
		System.out.println(it.next());
		it.remove();
		System.out.println(stack);

		/* an output must be as the following:
		*************************************
		C
		B
		A
		[]
		*************************************
		*/
	}

	private static void test7() {

		Stack stack = new StackImpl();
		stack.push("A");
		stack.push("B");
		stack.push("C");

		Iterator it = stack.iterator();

		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.next());
		it.remove();
		System.out.println(stack);

		it = stack.iterator();

		System.out.println(it.next());
		it.remove();
		System.out.println(stack);

		it = stack.iterator();

		System.out.println(it.next());
		it.remove();
		System.out.println(stack);

		/* an output must be as the following:
		*************************************
		C
		B
		A
		[B, C]
		C
		[B]
		B
		[]
		*************************************
		*/
	}

	private static void test8() {

		Stack stack = new StackImpl();
		stack.push("A");
		stack.push("B");
		stack.push("C");

		Iterator it = stack.iterator();
		System.out.println(it.next());
		it.remove();
		try {
			it.remove();
		} catch (IllegalStateException ex) {
			System.out.println("exception");
		}

		/* an output must be as the following:
		*************************************
		C
		exception
		*************************************
		*/
	}

	private static void test9() {

		Stack stack = new StackImpl();
		stack.push("A");
		stack.push("B");
		stack.push("C");

		Iterator it = stack.iterator();
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

	private static void test10() {

		Stack stack = new StackImpl();
		stack.push("A");
		stack.push("B");
		System.out.println(stack.top());
		System.out.println(stack.pop());
		System.out.println(stack.top());
		System.out.println(stack.pop());
		/* an output must be as the following:
		*************************************
		B
		B
		A
		A
		*************************************
		*/
	}

}
