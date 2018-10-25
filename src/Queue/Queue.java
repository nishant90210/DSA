package Queue;

import java.util.Arrays;

/**
 * Created by NISHANT on 9/14/17.
 */
public class Queue {

    private String[] queueArray;
    private int front, rear, queueSize, numberOfItems =0;

    public Queue(int size){
        queueSize = size;
        queueArray = new String[queueSize];
        Arrays.fill(queueArray, "-1");
    }

    private void insert(String input){

        if (numberOfItems + 1 <= queueSize){
            queueArray[rear] = input;
            rear++;
            numberOfItems++;
            System.out.println("INSERT " + input + " Was Added to the Stack\n");
        }else {
            System.out.println("Sorry But the Queue is Full");
        }
    }

    private void remove(){
        if (numberOfItems > 0){
            System.out.println("REMOVE " + queueArray[front] + " Was Removed From the Queue\n");
            queueArray[front] = "-1";
            front++;
            numberOfItems--;
        }else {
            System.out.println("Sorry But the Queue is Empty");
        }
    }

    public void peek(){
        System.out.println("The First Element is " + queueArray[front]);
    }

    public void priorityInsert(String input){
        int i;
        if(numberOfItems == 0){
            insert(input);
        } else {
            for(i = numberOfItems-1; i >= 0; i--){
                if(Integer.parseInt(input) > Integer.parseInt(queueArray[i])){
                    queueArray[i+1] = queueArray[i];
                } else {
                    break; // Done shifting items in queue
                }
            }
            queueArray[i+1] = input;
            rear++;
            numberOfItems++;
        }
    }

    public void displayTheQueue(){
        for(int n = 0; n < 61; n++){
            System.out.print("-");
        }
        System.out.println();
        for(int n = 0; n < queueSize; n++){
            System.out.format("| %2s "+ " ", n);
        }
        System.out.println("|");
        for(int n = 0; n < 61; n++) System.out.print("-");
        System.out.println();
        for(int n = 0; n < queueSize; n++){
            if(queueArray[n].equals("-1")) System.out.print("|     ");
            else System.out.print(String.format("| %2s "+ " ", queueArray[n]));
        }
        System.out.println("|");
        for(int n = 0; n < 61; n++){
            System.out.print("-");
        }
        System.out.println();
        // Number of spaces to put before the F
        int spacesBeforeFront = 3*(2*(front+1)-1);
        for(int k = 1; k < spacesBeforeFront; k++){
            System.out.print(" ");
        }
        System.out.print("F");
        // Number of spaces to put before the R
        int spacesBeforeRear = (2*(3*rear)-1) - (spacesBeforeFront);
        for(int l = 0; l < spacesBeforeRear; l++){
            System.out.print(" ");
        }
        System.out.print("R");
        System.out.println("\n");
    }

    public static void main(String[] args) {
        Queue queue  = new Queue(6);
        queue.priorityInsert("3");
        queue.priorityInsert("5");
        queue.priorityInsert("7");
        queue.priorityInsert("2");
        queue.priorityInsert("9");

        queue.displayTheQueue();
    }
}