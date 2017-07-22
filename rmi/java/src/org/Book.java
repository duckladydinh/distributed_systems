package org;

import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Book extends UnicastRemoteObject implements BOOK {
    public String name;
    ArrayList<Page> p;
    public Book() throws Exception {
        this.name = "I am just a little book";
        p = new ArrayList<>();
    }
    public Book(String name) throws Exception {
        this.name = name;
        p = new ArrayList<>();
    }
    public void add(String content) throws Exception {
        Page p = new Page(content);
        this.p.add(p);
    }
    public void show() throws Exception {
        System.out.println(name);
        for (Page p: this.p) {
            System.out.println(p.read());
        }
    }
}
