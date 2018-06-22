package com.drobek.practice;

public class DoubleLinked {

    private Node firstNode;


    public void addNode(int value) {
        Node newNode = new Node();
        newNode.setValue(value);
        if (firstNode == null) {
            firstNode = newNode;

        } else {
            Node current = firstNode;
            while (current.getNext() != null) {
                current = current.getNext();

            }
            current.setNext(newNode);
            newNode.setPrev(current);
        }

    }

    public void print() {
        if (firstNode != null) {
            Node current = firstNode;
            System.out.print("Node list " + firstNode.getValue());
            // System.out.println(" this is value " + firstNode.getValue() + " previous "+firstNode/.getPrev() + " this is next " + firstNode.getNext().getValue());
            while (current.getNext() != null) {
                current = current.getNext();
                System.out.print("," + current.getValue());
                //   if(current.getNext() !=null){
                // System.out.println(" this is value " + current.getValue() + " previous "+current.getPrev().getValue() + " this is next " + current.getNext().getValue());
                // }else {

                //   System.out.println(" this is value " + current.getValue() + " previous " + current.getPrev().getValue() + " this is next " + current.getNext());
                // }
            }
        } else {
            System.out.println("Your list is empty !");
        }
    }

    public void removeLast() {
        if (firstNode != null) {
            if (firstNode.getNext() == null) {
                firstNode.setPrev(null);
                firstNode.setNext(null);
            } else {
                Node current = firstNode;
                while (current.getNext() != null) {
                    if (current.getNext().getNext() == null) {
                        current.setNext(null);
                    } else {
                        current = current.getNext();
                    }
                }
            }
        } else {
            System.out.println("Nothing to remove");
        }
    }

    public void removeAny(int whichNode) {

        if (firstNode.getNext() == null) {
            if (whichNode == firstNode.getValue()) {
                firstNode = null;
            }
        } else {

            Node current = firstNode;
            while (current.getNext() != null) {

                if (current.getPrev() == null && current.getValue() == whichNode) {
                    current.getNext().setPrev(null);
                    current = current.getNext();
                    firstNode = current;

                } else {
                    if (current.getNext().getNext() == null && current.getNext().getValue() == whichNode) {

                        removeLast();
                    }
                    else{
                        current = current.getNext();
                        if (current.getValue() == whichNode) {

                            current.getPrev().setNext(current.getNext());
                            current.getNext().setPrev(current.getPrev());

                            current.setPrev(current.getPrev());
                            current.setNext(current.getNext().getNext());
                        }
                    }
                }

            }
        }
    }
}
