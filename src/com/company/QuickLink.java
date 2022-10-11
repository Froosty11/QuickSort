package com.company;

public class QuickLink {

    Node head;
    Node tail;

    public QuickLink() {
    }

    public String toString() {
        System.out.println("Elements include: ");
        StringBuilder stringBuilder = new StringBuilder();

        if (head == null) {
            stringBuilder.append("No elements found");
            return stringBuilder.toString();
        } else {
            Node current = head;
            while (current != null) {
                stringBuilder.append(current.getData() + "\t");
                current = current.nxt;
            }
            return stringBuilder.toString();
        }
    }

    public void appendData(int data) {

        Node current = head;
        if (head == null) {
            head = new Node(data);
            tail = head;
        } else {
            if (tail.nxt != null) {
                tail.nxt.nxt = new Node(data);
                tail = tail.nxt.nxt;
                return;
            }
            while (current.nxt != null) {
                current = current.nxt;
            }
            current.nxt = new Node(data);
            tail = current.nxt;
        }
    }

    public void appendLink(QuickLink quickLink) {
        if (quickLink.head == null) {
            return;
        }
        this.tail.nxt = quickLink.head;
    }

    public void appendNode(Node node) {

        if (head == null) {
            head = node;
            tail = head;
            return;
        } else {
            if (tail.nxt != null) {
                tail.nxt.nxt = node;
                tail = tail.nxt.nxt;
                return;
            }
            Node current = head;
            while (current.nxt != null) {
                current = current.nxt;
            }
            current.nxt = node;
            tail = current.nxt;
        }
    }

    public static void quickSortll(Node lo, Node hi){

        if(lo == null || lo == hi || lo == hi.nxt)
            return;

        Node i = partition(lo, hi);
        quickSortll(lo, i);

        if(i != null && i == lo)
            quickSortll(i.nxt, hi);

        else if(i != null && i.nxt != null)
            quickSortll(i.nxt.nxt, hi);
    }

    public static Node partition(Node lo, Node hi) {

        if(lo == hi || lo == null || hi == null)
            return lo;

        Node i = lo;
        Node curr = lo;
        int pivot = hi.data;

        while(lo != hi){
            if(lo.data < pivot){
                i = curr;
                int temp = curr.data;
                curr.data = lo.data;
                lo.data = temp;
                curr = curr.nxt;
            }
            lo = lo.nxt;
        }
        int temp = curr.data;
        curr.data = pivot;
        hi.data = temp;
        return i;
    }

    public static Node iterate(Node lo, Node hi){
        Node current = lo;
        while(current.nxt != null && current.nxt != hi){
            current = current.nxt;
        }
        return current;
    }
}

