package org;

import java.rmi.Remote;

public interface BOOK extends Remote {
    public void add(String content) throws Exception;
    public void show() throws Exception;
}
