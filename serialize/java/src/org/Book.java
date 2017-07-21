package org;

import java.io.Serializable;
import java.util.ArrayList;

public class Book implements Serializable {
    public String name;
    ArrayList<Page> p;
    public Book() {
        this.name = "I am just a little book";
        p = new ArrayList<>();
    }
    public Book(String name) {
        this.name = name;
        p = new ArrayList<>();
    }
    public void add(Page p) {
        this.p.add(p);
    }
    public void show() {
        System.out.println(name);
        for (Page p: this.p) {
            System.out.println(p.read());
        }
    }
}
