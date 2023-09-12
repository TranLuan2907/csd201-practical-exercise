/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PracticalExercise1;

/**
 * Implementing singly linked list using string value instead of integer.
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

    }

    public void addToTail(String x) {

    }

    public void addAfter(Node p, String x) {

    }

    public void traverse() {

    }

    public String deleteFromHead() {

    }

    public String deleteFromTail() {

    }

    public String deleteAfter(Node p) {

    }

    public void delete(String x) {

    }

    public Node search(String x) {

    }

    public String count() {

    }

    public boolean isEmpty() {
        return head == null;
    }


    /**
     * Used to add values to test the algorithm
     */
    public static void main(String[] args) {

    }
}
