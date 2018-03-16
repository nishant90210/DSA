package LinkedList;

/**
 * Created by NISHANT on 11/15/17.
 */
public class IntersectionOfTwoList {

    public static void main(String[] args) {
        SinglyLinkedList list1 = new SinglyLinkedList();

        // creating first linked list1
        list1.addLast(3);
        list1.addLast(6);
        list1.addLast(13);
        list1.addLast(15);
        list1.addLast(30);

        SinglyLinkedList list2 = new SinglyLinkedList();
        // creating second linked list1
        list2.addLast(10);
        list2.addLast(15);
        list2.addLast(30);

        System.out.println("The node of intersection is " + getIntersection(list1.head, list2.head));

    }

    private static Integer getIntersection(Node list1, Node list2) {

        int list1Length = getLength(list1);
        int list2Length = getLength(list2);
        int difference = Math.abs(list1Length-list2Length);
        if (list1Length > list2Length){
            while (difference > 0 ){
                list1 = list1.next;
                difference--;
            }
        }
        while (list1.data != list2.data){
            list1 = list1.next;
            list2 = list2.next;
        }
        return (Integer) list1.data;
    }

    private static int getLength(Node node){

        if (node == null){
            return 0;
        }
        return 1 + getLength(node.next);
    }
}
