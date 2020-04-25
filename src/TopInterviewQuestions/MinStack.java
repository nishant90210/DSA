package TopInterviewQuestions;

class SpecStack{
    public int value;
    public int min;
    public SpecStack next;

    public SpecStack(int value, int min){
        this.value = value;
        this.min = min;
    }
}

public class MinStack {
    public SpecStack top;

    public void push(int x) {
        if(top == null){
            top = new SpecStack(x, x);
        }else{
            SpecStack e = new SpecStack(x, Math.min(x,top.min));
            e.next = top;
            top = e;
        }

    }

    public void pop() {
        if(top == null)
            return;
        SpecStack temp = top.next;
        top.next = null;
        top = temp;

    }

    public int top() {
        if(top == null)
            return -1;
        return top.value;
    }

    public int getMin() {
        if(top == null)
            return -1;
        return top.min;
    }

    public static void main(String[] args) {
        MinStack s = new MinStack();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.getMin());
        s.push(5);
        System.out.println(s.getMin());
    }
}
