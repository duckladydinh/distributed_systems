package org;

import java.io.Serializable;

public class Page implements Serializable {
    String content;
    public Page() {
        content = "I am just a single page";
    }
    public Page(String content) {
        this.content = content;
    }
    public void write(String content) {
        this.content = content;
    }
    public String read() {
        return this.content;
    }
}
