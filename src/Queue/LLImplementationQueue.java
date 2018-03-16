package Queue;

/**
 * Created by NISHANT on 9/15/17.
 */

class QNode {
    int data;
    QNode next;

    public QNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LLImplementationQueue {

    QNode front, rear;

    public LLImplementationQueue() {
        this.front = null;
        this.rear = null;
    }

    public void enqueue(int data){

        QNode tempNode = new QNode(data);
        if (this.rear == null){
            this.front = tempNode ;
            this.rear = tempNode ;
            return;
        }
        this.rear.next = tempNode;
        this.rear = tempNode;
    }

    public QNode dequeue() {

        if (this.front == null){
            return null;
        }
        QNode temp = this.front;
        this.front = this.front.next;

        if (this.front == null)
            this.rear = null;
        return temp;
    }

    public static void main(String[] args) {

        LLImplementationQueue llImplementationQueue = new LLImplementationQueue();
        llImplementationQueue.enqueue(1);
        llImplementationQueue.enqueue(2);
        llImplementationQueue.enqueue(3);
        llImplementationQueue.enqueue(4);
        llImplementationQueue.enqueue(5);
        llImplementationQueue.enqueue(6);

        llImplementationQueue.dequeue();
        llImplementationQueue.dequeue();
        llImplementationQueue.dequeue();

    }

}
