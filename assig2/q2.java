class FirstNonRepeatingStream {
    private static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node head;
    private Node tail;
    private int[] charFrequency = new int[256];
    private Node firstNonRepeating = null; 

    public FirstNonRepeatingStream() {
        head = null;
        tail = null;
    }

    public void add(char c) {
        charFrequency[c]++;
        Node newNode = new Node(c);

        if (head == null) {
            head = newNode;
            tail = newNode;
            firstNonRepeating = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        while (firstNonRepeating != null && charFrequency[firstNonRepeating.data] > 1) {
            firstNonRepeating = firstNonRepeating.next;
        }
    }

    public char getFirstNonRepeating() {
        if (firstNonRepeating != null) {
            return firstNonRepeating.data;
        }
        return '-';
    }

   public void displayStream() {
    Node current = head;
    System.out.print("Input: [");
    boolean firstElement = true;
    while (current != null) {
        if (!firstElement) {
            System.out.print(", ");
        }
        System.out.print("'" + current.data + "'");
        current = current.next;
        firstElement = false;
    }
    System.out.println("]");
}
}


public class q2 {
    public static void main(String[] args) {
        FirstNonRepeatingStream stream1 = new FirstNonRepeatingStream();
        stream1.add('a');
        stream1.add('b');
        stream1.add('a');
        stream1.displayStream();
        System.out.println("Output: " + stream1.getFirstNonRepeating()); 

        FirstNonRepeatingStream stream2 = new FirstNonRepeatingStream();
        stream2.add('a');
        stream2.add('b');
        stream2.add('a');
        stream2.add('b');
        stream2.displayStream();
        System.out.println("Output: " + stream2.getFirstNonRepeating());

        FirstNonRepeatingStream stream3 = new FirstNonRepeatingStream();
        stream3.add('a');
        stream3.add('b');
        stream3.add('b');
        stream3.displayStream();
        System.out.println("Output: " + stream3.getFirstNonRepeating()); 
    }
}
