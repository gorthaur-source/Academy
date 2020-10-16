package org.academiadecodigo.bootcamp.containers;

public class LinkedList {

    private Node head;
    private int length = 0;

    public LinkedList() {
        this.head = new Node(null);
    }

    public int size() {
        return length;
    }

    /**
     * Adds an element to the end of the list
     *
     * @param data the element to add
     */
    public void add(Object data) {

        Node node = new Node(data);
        Node iterator = head;
        while (iterator.getNext() != null) {
            iterator = iterator.getNext();
        }
        iterator.setNext(node);
        length++;

    }

    /**
     * Obtains an element by index
     *
     * @param index the index of the element
     * @return the element
     */
    public Object get(int index) {

        Node iterator = head.getNext();
        for(int i = 0; i < length; i++) {
            if (i == index) {
                return (iterator.getData());
            }
            iterator = iterator.getNext();
        }
        return null;
    }

    /**
     * Returns the index of the element in the list
     *
     * @param data element to search for
     * @return the index of the element, or -1 if the list does not contain element
     */
    public int indexOf(Object data) {

        int index = 0;
        Node iterator = head.getNext();
        for(int i = 0; i < length; i++) {
            if (iterator.getData() == data) {
                return index;
            }
            index++;
            iterator = iterator.getNext();
        }
        return -1;
}

    /**
     * Removes an element from the list
     * @param data the element to remove
     * @return true if element was removed
     */
    public boolean remove(Object data) {

        Node currentNode = head.getNext();
        Node previousNode = head;
        for(int i = 0; i < length; i++) {
            if (currentNode.getData() == data) {
                previousNode.setNext(currentNode.getNext());
                currentNode.setNext(null);
                length--;
                return true;
            }
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }
        return false;
    }
    private class Node {

        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
            next = null;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}
