package LinkedList;

/**
 * Created by NISHANT on 8/28/18.
 */
public class RotateLL {

    public static void main(String[] args) {

        int k = 4;
        Reverse reverse = new Reverse();
        reverse.push(1);
        reverse.push(2);
        reverse.push(3);
        reverse.push(4);
        reverse.push(5);
        reverse.push(6);

        reverse.printList(reverse.head);

        Reverse.Node node = rotateLL(reverse, k);
        System.out.println();
        reverse.printList(node);

    }

    private static Reverse.Node rotateLL(Reverse reverse, int k) {

        int count = 1;
        Reverse.Node temp = reverse.head;
        Reverse.Node new_node;
        Reverse.Node tempNode;

        while (count < k && temp != null){
            count++;
            temp = temp.next;
        }
        new_node = temp.next;
        temp.next = null;
        tempNode = new_node;
        while (new_node.next != null){
            new_node = new_node.next;
        }
        new_node.next = reverse.head;
        return tempNode;
    }
}
