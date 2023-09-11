/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PracticalExercise1;





/**
 * This is some of my codes contributing to the subject CSD201 practice
 * exercises
 *
 * @author nklua
 */
public class Q1 {

    //We just need head in singly linked list because
    //the tail of this list will point to null.
    private Node head;

    public Q1() {
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
     *
     * This class is marked as static to allow access to its attribute
     * throughout the entire class, including methods that handle information.
     */
    public static class Node {

        //This attributes are set private because it hides internal details of
        //a class and only expose only the necessary information - Encapsulation.
        private int data;
        private Node next;

        //Constructor to get parameteres which are passed through some methods.
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Inserts a new node with the given value at the beginning of the list.
     *
     * @param x
     */
    public void addToHead(int x) {
        //Create a new node, allocate some data
        Node node = new Node(x);
        node.next = head;
        head = node;
    }

    /**
     * Insert a new node at the end of the list
     *
     * @param x
     */
    public void addToTail(int x) {
        //Create a new node, allocate some data
        Node node = new Node(x);

        //Check if the list is empty, if it is
        //assign head to point to the new node
        if (head == null) {
            head = node;
            return;
        }

        //If the list is not empty, traverse to the end of the list
        //the last node will point to the node we've just created.
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
    }

    /**
     * Insert a new node after a given node Given a node p, insert a new node
     * after the given p node
     *
     * @param p
     * @param x
     */
    public void addAfter(Node p, int x) {
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

    /**
     * Traverse from head to tail and display info of all nodes in the list
     */
    public void traverse() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println(); //Print a newline to separate output from the program
    }
    
    /**
     * Delete the tail and return its info.
     * @return 
     */
    public int deleteFromTail() {
        //Check if the list is empty
        if (head == null) {
            return -1;
        }
        
        //Check if the list contains only 1 node
        if (head.next == null) {
            return -1;
        }
        int data = head.data;
        Node secondLast = head;
        //This code is used to find the second last node in the list.
        //After that delete the last node by assign next last node to null.
        while (secondLast.next.next != null) {
            secondLast = secondLast.next;
        }
        secondLast.next = null;
        return data;
    }
    
    
    /**
     * Delete the head node and return its info
     * @return 
     */
    public int deleteFromHead() {
        if (head == null) {
            return -1; // Return a sentinel value to indicate failure (e.g., -1 for an integer
                       // We don't use return; in this case due to int value.
                       // Empty list, nothing to delete
        }
        
        int data = head.data; //Used to store current information of the current node
        Node current = head;
        head = head.next;
        return data; //Return the information of deleted node.
    }

    /**
     * Delete the node after node p and return its info
     *
     * @param p
     */
    public int deleteAfter(Node p) {
        // Check if the list is empty
        if (head == null) {
            System.err.println("The list is empty. Nothing to delete.");
            return -1; // Return a sentinel value to indicate failure (e.g., -1 for an integer
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
            return -1; // Return a sentinel value to indicate failure
        }

        // Check if 'p' is the last node in the list
        if (current.next == null) {
            System.err.println("Node 'p' is the last node. Nothing to delete after it.");
            return -1; // Return a sentinel value to indicate failure
        }

        // Delete the node after 'p' and return its info
        int deletedInfo = current.next.data; // Store the info of the node to be deleted
        current.next = current.next.next; // Update the 'next' reference of 'p'
        return deletedInfo; // Return the info of the deleted node
    }
    
    /**
     * Delete the first node whose info is equal to x
     * @param x 
     */
    public void delete(int x) {
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
    /**
     * Search and return the reference to the first node having info x
     * @param x
     * @return 
     */
    public Node search(int x) {
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
    public int count() {
        if (head == null) {
            return 0; //If the list is empty, return 0 indicates there is not list
        }
        Node current = head;
        int count = 0; //Count = 0 because we want to assume that there is no node intially, then count up to 1, 2,3..
                       //If we count from 1, we assume there is 1 node already so it's wrong
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    
    /**
     * Delete an i-th node on the list. Be sure that such a node exists.
     * @param x 
     */
    public void delete2(int x) {
        //Position is valid and starting from 1
        //3 -> 4 -> 7 -> 8 -> 9 -> null

        //Check if the list is empty
        if (head == null) {
            System.err.println("The list is empty. Nothing to print out!!!"); // I use System.err instead because it will print the red messages in the output
                                                                              // which I think it would be cool!!!.
            return;
        }

        //Special case: If the position is 1 (first node)
        if (x == 1) {
            head = head.next;
            return;
        }
        Node previous = head; //Create a temporary previous node in order to keep track of the list

        // Traverse the list to find the node just before the one to be deleted.  
        for (int i = 1; previous != null && i < x - 1; i++) {
            previous = previous.next;
        }

        //Check if it is out of bounds.
        if (previous == null || previous.next == null) {
            System.err.println("Out of bound!!!");
            return;
        }

        previous.next = previous.next.next;
    }
    
    /**
     * Sort the list by ascending order of info.
     */
   public void sort() {
    // Node current will point to head, index will point to the next position of current
    Node current = head, index = null;
    int temp;
    // If the list is empty or has only one element, it is already sorted.
    if (head == null || head.next == null) {
        return;
    } else {
         // Node index will point to node next to
         // current
        while (current != null) {
            index = current.next;
            
            while (index != null) {
                if (current.data > index.data) {
                    temp = current.data;
                    current.data = index.data;
                    index.data = temp;
                }
                index = index.next;
            }
            current = current.next;
        }
    }

   
}

    
    /**
     * Delete node p if it exists in the list.
     * @param p 
     */
    public void remove(Node p) {
        if (head == null || p == null) {
            System.err.println("Nothing to remove!");
            return;
        }
        
        //Special case: If Node p is in the first node, shift it toward 1 node, and delete the node before.
        if (head == p) {
            head = head.next;
            return;
                  
        }
        
        Node current = head;
        while (current != null && current != p) {
            current = current.next;
        }
        
        if (current == null) {
            System.err.println("Not found!");
            return;
        }
        
        current.next = current.next.next;
    }
    
    public void addBefore() {
        
    }
    
    public int[] toArray() {
        
    }
    
    /**
     * Return the maximum value in the list
     * @return 
     */
    public int max() {
        //The idea here is we assign max value is the smallest value (-32767), after which we traverse 
        //the list and check if any node bigger than max. If it is, assign that node is the new max and 
        //repeat.
        int max = Integer.MIN_VALUE;
        while (head != null) {
            //If max is less than head.data, then assign value of head.data to max
            //Otherwise node point to another node
            if (head.data > max) {
                max = head.data;
               
            }
            head = head.next;
        }
        return max;
    }
    
    /**
     *  Return the minimum value in the list
     *  Apply the same logic as finding the maximum value in the list.
     * @return 
     */
    public int min() {
        int min = Integer.MAX_VALUE;
        while (head != null) {
            if (head.data < min) {
                min = head.data;
            }
            head = head.next;
        }
        return min;
    }
    
    /**
     * Return sum of all values in list
     * Idea: Call a function by passing the head and variable to store the sum.
     *       Then recursively call the function by passing the next of current node and sum variable.
     *       Add the value of the current node to the sum.
     */
    public int sum() {
        Node current = head;
        int sum = 0;
        while (current != null) {
            sum += current.data;
            current = current.next;
        }
        return sum;
    }
    
    public double average() {
        Node current = head;
        int sum = 0;
        int count = 0;
        double average = 0;
        
        // Avoiding division by zero
        if (head == null) {
            return 0;
        }
        
        while (current != null) {
            count++;
            sum += current.data;
            current = current.next;
        }
        
        average = (double) sum / count;
        return average;
    }
    
    /**
     * Check and return true if the list is sorted, return false if the list is not sorted
     * First iterate through the list and compare node's value with next node's value
     * If next node's value smaller than current node's value, return false to indicates the list is not sorted
     * If reaching the end of the list without finding such instance, return true to indicates that the list is sorted
     * @return 
     */
    public boolean sorted() {
        // An empty list or a list with 1 node is considered sorted
        if (head == null || head.next == null) {
            return true;
        }
        
        Node current = head;
        while (current.next != null) {
            //Check if next node's value is smaller than current node's value
            if (current.data > current.next.data) {
                return false; // Indicate that the node is not sorted
            }
            current = current.next;
        }
        return true; //If we reach the end of the list without finding an out-of-order pair, then the list is sorted
    }
    
    /**
     * Insert node with value x into sorted list so that the new list is sorted.
     * @param x 
     */
    public void insert(int x) {
        Node newNode = new Node(x);
        //If the list is empty or node's value is smaller than head node.
        //Insert new node at the beginning of the list
        if (head == null || x < head.data) {
            newNode.next = head;
            head = newNode;
            return;
        }
        //Traverse the list until we find the correct position to insert the new node
        Node current = head;
        while (current.next != null && x > current.next.data) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
    }
    /**
     * Reverse a singly linked list using iterative method
     */
    public void reverse() {
        Node previous = null;
        Node current = head;
        Node nxt = null;
        while (current != null) {
            nxt = current.next;
            current.next = previous;
            previous = current;
            current = nxt;
        }
        head = previous; //Previous becoms a new head
    }
    /**
     * Check whether two singly linked list have the same contents
     * Traverse both the linked lists simultaneously
     * If one data of the current node is not equal the other node, return false
     * Return true if both of them are identical.
     * In this method, I will use both iterative and recursive method.
     * @param
     * @return 
     */
    public boolean areIdentical(Node head1, Node head2) {
//        Node firstRunner = head1;
//        Node secondRunner = head2;
//        
//        if (head1 == null && head2 == null) {
//            return true;
//        }
//        
//        while (head1 != null && head2 != null) {
//            if (firstRunner.data != secondRunner.data) {
//                break;
//            }
//            //This code mean if we traverse to the end of both linked list, this mean
//            //these values in this list are indentical.
//            if (firstRunner.next == null && secondRunner.next == null) {
//                return true;
//            }
//            firstRunner = firstRunner.next;
//            secondRunner = secondRunner.next;
//        }
//        return false;
//        
        //Recursion Method
        if (head1 == null && head2 == null) return true;
        if (head1 == null && head2 != null) return false;
        if (head1 != null && head2 == null) return false;
        if (head1.data != head2.data) return false;
        return areIdentical(head1.next , head2.next);
    }
    
    public static void main(String[] args) {
        
    }
}
