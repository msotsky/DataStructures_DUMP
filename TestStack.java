/*
Maxime Sotsky 0270251
COMP 2611
2019-11-17
*/
public class TestStack {
	public static void main(String[] args){

		StackArray<Integer> unbounded1 = new StackArray<Integer>(4);
		StackArray<Integer> unbounded2 = new StackArray<Integer>(4);

		unbounded1.push(5);
		unbounded1.push(7);
		unbounded1.push(4);
		unbounded1.push(1);

		//System.out.println("TESTING" + unbounded1.negativeOrPositive(unbounded1));

		unbounded2.push(9);
		unbounded2.push(1);
		unbounded2.push(1);
		unbounded2.push(6);
		int answer = 5741 + 9116;
		System.out.println(" 5741 + 9116 : Answer = " + answer);

		StackArray<Integer> myStack = new StackArray<Integer>(unbounded1.getSizeArr() + unbounded2.getSizeArr());
		myStack = StackArray.addUnboundedIntegers(unbounded1,unbounded2);

		while (myStack.isEmpty() == false)
		{
			System.out.println(myStack.pop());
		}
//====================================================================================================
		int answer2 = 888 + 777;
		System.out.println("888 + 777 " +answer2);
		StackArray<Integer> unbounded3 = new StackArray<Integer>(3);
		StackArray<Integer> unbounded4 = new StackArray<Integer>(3);
		unbounded3.push(8);
		unbounded3.push(8);
		unbounded3.push(8);
		unbounded4.push(7);
		unbounded4.push(7);
		unbounded4.push(7);
		StackArray<Integer> myStack2 = new StackArray<Integer>(unbounded3.getSizeArr() + unbounded4.getSizeArr());
		myStack2 = StackArray.addUnboundedIntegers(unbounded3,unbounded4);
		while (myStack2.isEmpty() == false)
		{
			System.out.println(myStack2.pop());
		}
//===================================================================================================
		int answer3 = -4783 + 5874;
		System.out.println("-4783 + 5874 = " +answer3); //- + + = +
		StackArray<Integer> unbounded5 = new StackArray<Integer>(4);
		StackArray<Integer> unbounded6 = new StackArray<Integer>(4);

		unbounded5.push(-4);
		unbounded5.push(7);
		unbounded5.push(8);
		unbounded5.push(3);

		unbounded6.push(5);
		unbounded6.push(8);
		unbounded6.push(7);
		unbounded6.push(4);

		StackArray<Integer> myStack3 = new StackArray<Integer>(unbounded5.getSizeArr() + unbounded6.getSizeArr());
		myStack3 = StackArray.addUnboundedIntegers(unbounded5,unbounded6);
		while (myStack3.isEmpty() == false)
		{
			System.out.println(myStack3.pop());
		}
//====================================================================================================
		int answer4 = 4783 + -5874;
		System.out.println("4783 + -5874 = " +answer4); //- + + = +
		StackArray<Integer> unbounded7 = new StackArray<Integer>(4);
		StackArray<Integer> unbounded8 = new StackArray<Integer>(4);

		unbounded7.push(4);
		unbounded7.push(7);
		unbounded7.push(8);
		unbounded7.push(3);

		unbounded8.push(-5);
		unbounded8.push(8);
		unbounded8.push(7);
		unbounded8.push(4);
		StackArray<Integer> myStack4 = new StackArray<Integer>(unbounded7.getSizeArr() + unbounded8.getSizeArr());
		myStack4 = StackArray.addUnboundedIntegers(unbounded7,unbounded8);
		while (myStack4.isEmpty() == false)
		{
			System.out.println(myStack4.pop());
		}
	}
}
