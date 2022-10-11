package com.company;

public class Node {
    int data;
    Node nxt;

    public void setData(int data){
        this.data = data;
    }
    public Node getNode(){
        return this;
    }
    public int getData(){
        return this.data;
    }
    public Node(int data ) {
        setData(data);
    }
}
