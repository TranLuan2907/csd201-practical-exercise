/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PracticalExercise1;

/**
 * Implementing singly linked list using string value instead of integer.
 *
 * @author nklua
 */
public class Q2 {
    private Node head;

    public Q2() {
        head = null;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    /**
     * Nested class are used in this case in order to increase the use of
     * encapsulation and creates more readable and maintainable code
     * This class is marked as static to allow access to its attribute
     * throughout the entire class, including methods that handle information.
     */
    public static class Node {
        //These attributes are set private because it hides internal details of
        //a class and only expose the necessary information - Encapsulation.
        private Node next;
        private String data;

        /**
         * Default constructor is used to accept arguments which is passed in parameters.
         */
        public Node() {

        }

        public Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addToHead(String x) {
        Node node = new Node(x);
        node.next = head;
        head = node;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ->");
            current = current.next;
        }
        System.out.println(" null");
        System.out.println();
    }

    public void addToTail(String x) {
        Node node = new Node(x);
        if (isEmpty()) {
            head = node;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
    }

    public void addAfter(Node p, String x) {
        //Create a new node, allocate some data
        Node node = new Node(x);
        //Check if the previous node, which is p in this case is null and this can
        //result in a broken and incomplete link list.
        if (p == null) {
            System.err.println("Previous node cannot be null!!!");
        } else {
            node.next = p.next;
            p.next = node;
        }
    }

    public void traverse() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println(); //Print a newline to separate output from the program
    }


    public String deleteFromHead() {
        if (head == null) {
            return null; // Return a sentinel value to indicate failure (e.g., -1 for an integer
            // We don't use return; in this case due to int value.
            // Empty list, nothing to delete
        }

        String data = head.data; //Used to store current information of the current node
        Node current = head;
        head = head.next;
        current.next = null;
        return data; //Return the information of deleted node.
    }

    public String deleteFromTail() {
        //Check if the list is empty
        if (head == null) {
            return null;
        }

        //Check if the list contains only 1 node
        if (head.next == null) {
            return null;
        }
        String data = head.data;
        Node secondLast = head;
        //This code is used to find the second last node in the list.
        //After that delete the last node by assign next last node to null.
        while (secondLast.next.next != null) {
            secondLast = secondLast.next;
        }
        secondLast.next = null;
        return data;

    }

    public String deleteAfter(Node p) {
        // Check if the list is empty
        if (head == null) {
            System.err.println("The list is empty. Nothing to delete.");
            return null; // Return a sentinel value to indicate failure (e.g., -1 for an integer
            // We don't use return; in this case due to int value.
        }

        // Find the node 'p' in the list
        Node current = head;
        while (current != null && current != p) {
            current = current.next;
        }

        // Check if 'p' was not found in the list
        if (current == null) {
            System.err.println("Node 'p' not found in the list.");
            return null; // Return a sentinel value to indicate failure
        }

        // Check if 'p' is the last node in the list
        if (current.next == null) {
            System.err.println("Node 'p' is the last node. Nothing to delete after it.");
            return null; // Return a sentinel value to indicate failure
        }

        // Delete the node after 'p' and return its info
        String deletedInfo = current.next.data; // Store the info of the node to be deleted
        current.next = current.next.next; // Update the 'next' reference of 'p'
        return deletedInfo; // Return the info of the deleted node
    }

    public void delete(String x) {
        //Check if the list is empty
        if (head == null) {
            return;
        }

        // If the first node contains the data to be deleted
        if (head.data == x) {
            head = head.next;
            return; // Node deleted, exit the method
        }

        Node current = head;
        Node previous = null;

        while (current != null && current.data != x) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            System.err.println("Not Found!");
            return;// Node not found, exit the method
        }

        previous.next = current.next;

    }
    public Node search(String x) {
        Node current = head;
        while (current != null) {
            if (current.data == x) {
                return current; // Return the reference to the first node with data x
            }
            current = current.next;
        }
        return null; // Node with data x not found
    }
    /**
     * Count the number of nodes in list.
     * @return
     */
    public boolean isEmpty() {
        return head == null;
    }


    /**
     * Used to add values to test the algorithm
     */
    public static void main(String[] args) {
        Q2 linkedList = new Q2();

        //Check add to head method.
//
//        linkedList.addToHead("FPT");
//        linkedList.addToHead("HCMUT");
//        linkedList.addToHead("HCMUS");
//        linkedList.display();


        //Check add to tail method.
//        linkedList.addToTail("FPT");
//        linkedList.addToTail("HCMUT");
//        linkedList.addToTail("HCMUS");
//        linkedList.display();
    }
}
