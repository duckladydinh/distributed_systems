package org;

import java.rmi.server.UnicastRemoteObject;

public class Page extends UnicastRemoteObject implements PAGE {
    String content;
    public Page() throws Exception {
        content = "I am just a single page";
    }
    public Page(String content) throws Exception {
        this.content = content;
    }
    public void write(String content) throws Exception {
        this.content = content;
    }
    public String read() throws Exception {
        return this.content;
    }
}
