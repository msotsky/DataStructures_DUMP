/*
Maxime Sotsky 0270251
COMP 2611
2019-11-17
*/
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StackArrayTest2 {

	@Test
	void test1() {
		StackArray<Integer> unbounded1 = new StackArray<Integer>(4);
		StackArray<Integer> unbounded2 = new StackArray<Integer>(4);
		unbounded1.push(5);
		unbounded1.push(7);
		unbounded1.push(4);
		unbounded1.push(1);
		
		unbounded2.push(9);
		unbounded2.push(1);
		unbounded2.push(1);
		unbounded2.push(6);
		StackArray<Integer> unbounded = new StackArray<Integer>(4);
		unbounded = StackArray.addUnboundedIntegers(unbounded1,unbounded2);
		
        assertEquals("1", unbounded.pop().toString(), "5741 + 9116 = 14857");
        assertEquals("4", unbounded.pop().toString(), "5741 + 9116 = 14857");
        assertEquals("8", unbounded.pop().toString(), "5741 + 9116 = 14857");
        assertEquals("5", unbounded.pop().toString(), "5741 + 9116 = 14857");
        assertEquals("7", unbounded.pop().toString(), "5741 + 9116 = 14857");

	}
	@Test
	void test2() {
		StackArray<Integer> unbounded1 = new StackArray<Integer>(3);
		StackArray<Integer> unbounded2 = new StackArray<Integer>(3);
		unbounded1.push(8);
		unbounded1.push(8);
		unbounded1.push(8);
		unbounded2.push(7);
		unbounded2.push(7);
		unbounded2.push(7);
		StackArray<Integer> unbounded = new StackArray<Integer>(4);
		unbounded = StackArray.addUnboundedIntegers(unbounded1,unbounded2);
        assertEquals("1", unbounded.pop().toString(), "888 + 777 = 1665");
        assertEquals("6", unbounded.pop().toString(), "888 + 777 = 1665");
        assertEquals("6", unbounded.pop().toString(), "888 + 777 = 1665");
        assertEquals("5", unbounded.pop().toString(), "888 + 777 = 1665");
	}
	@Test
	void test3() {
		StackArray<Integer> unbounded1 = new StackArray<Integer>(4);
		StackArray<Integer> unbounded2 = new StackArray<Integer>(4);

		unbounded1.push(-4);
		unbounded1.push(7);
		unbounded1.push(8);
		unbounded1.push(3);

		unbounded2.push(5);
		unbounded2.push(8);
		unbounded2.push(7);
		unbounded2.push(4);
		
		StackArray<Integer> unbounded = new StackArray<Integer>(4);
		unbounded = StackArray.addUnboundedIntegers(unbounded1,unbounded2);
        assertEquals("1", unbounded.pop().toString(), "-4783 + 5874 = 1091");
        assertEquals("0", unbounded.pop().toString(), "-4783 + 5874 = 1091");
        assertEquals("9", unbounded.pop().toString(), "-4783 + 5874 = 1091");
        assertEquals("1", unbounded.pop().toString(), "-4783 + 5874 = 1091");

	}
	@Test
	void test4() {
		StackArray<Integer> unbounded1 = new StackArray<Integer>(4);
		StackArray<Integer> unbounded2 = new StackArray<Integer>(4);

		unbounded1.push(4);
		unbounded1.push(7);
		unbounded1.push(8);
		unbounded1.push(3);

		unbounded2.push(-5);
		unbounded2.push(8);
		unbounded2.push(7);
		unbounded2.push(4);
		
		StackArray<Integer> unbounded = new StackArray<Integer>(4);
		unbounded = StackArray.addUnboundedIntegers(unbounded1,unbounded2);
        assertEquals("1", unbounded.pop().toString(), "4783 + -5874 = -1091");
        assertEquals("0", unbounded.pop().toString(), "4783 + -5874 = -1091");
        assertEquals("9", unbounded.pop().toString(), "4783 + -5874 = -1091");
        assertEquals("-1", unbounded.pop().toString(), "4783 + -5874 = -1091");
	}

}
