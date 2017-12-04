package com.se.algorithm.chainreverse;

public class Note{
    public int data;
    public Note next;

    public Note(int data){
        this.data=data;
    }

    @Override
    public String toString() {
        return "Note{" +
                "data=" + data +
                '}';
    }
}
