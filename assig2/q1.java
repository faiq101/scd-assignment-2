class StackEmptyException extends Exception {
    public StackEmptyException(String message) {
        super(message);
    }
}

class GenericStack<T> {
    private class Node<T> {
        protected T element;
        protected Node<T> next;

        public Node(T elem) {
            element = elem;
            next = null;
        }
    }

    private Node<T> top;
    private int size; 

    public GenericStack() {
        top = null;
        size = 0; 
    }

    public void push(T elem) {
        Node<T> newNode = new Node<T>(elem);

        if (isEmpty()) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }

        size++;
    }

    public T pop() throws StackEmptyException {
        if (isEmpty()) {
            throw new StackEmptyException("Stack is empty! Cannot pop.");
        }

        T topElem = top.element;
        top = top.next;

        size--;

        return topElem;
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }

        return top.element;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }
}

public class q1 {
    public static void main(String[] args) {
        GenericStack<Integer> stack = new GenericStack<>();

        try {
            stack.push(10);
            stack.push(20);
            stack.push(30);
            System.out.println("Stack size: " + stack.size());
            int poppedElement = stack.pop();
            System.out.println("Popped element: " + poppedElement);
            System.out.println("Stack size after pop: " + stack.size());
            int peekedElement = stack.peek();
            System.out.println("Peeked element: " + peekedElement);
            while (!stack.isEmpty()) {
                stack.pop();
            }
            stack.pop();
        } catch (StackEmptyException e) {
            System.out.println("Error: " + e.getMessage());
        }

        GenericStack<String> stringStack = new GenericStack<>();

        try {
            stringStack.push("Hello");
            stringStack.push("World");
            stringStack.push("Who");
            System.out.println("String Stack size: " + stringStack.size());
            String poppedElement = stringStack.pop();
            System.out.println("Popped element: " + poppedElement);
            System.out.println("String Stack size after pop: " + stringStack.size());
            String peekedElement = stringStack.peek();
            System.out.println("Peeked element: " + peekedElement);
        } catch (StackEmptyException e) {
            System.out.println("Error: " + e.getMessage());
        }   

        GenericStack<Float> floatStack = new GenericStack<>();
        try{
            floatStack.push(3.14f);
            floatStack.push(1.618f);
            floatStack.push(2.718f);
            System.out.println("Float Stack size: " + floatStack.size());
            float poppedFloatElement = floatStack.pop();
            System.out.println("Popped element from Float Stack: " + poppedFloatElement);
            System.out.println("Float Stack size after pop: " + floatStack.size());
            float peekedFloatElement = floatStack.peek();
            System.out.println("Peeked element from Float Stack: " + peekedFloatElement);
        } catch (StackEmptyException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        }
    }
    