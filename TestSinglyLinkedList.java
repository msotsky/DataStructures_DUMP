public class TestSinglyLinkedList{

    public static void main(String[] args) {

        SinglyLinkedList myList = new SinglyLinkedList();
        myList.add("valkynes");
        myList.add("pepper");
        myList.add("notosha");
        myList.add("maria");
        myList.add("jane");
        myList.add("hope");
        System.out.println(myList.toString());
        SinglyLinkedList.leapFrogging(myList.getHead());
        System.out.println(myList.toString());
        

        
    } 
}

