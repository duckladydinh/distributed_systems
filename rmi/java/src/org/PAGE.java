package org;

import java.rmi.Remote;

public interface PAGE extends Remote {
    public void write(String content) throws Exception;
    public String read() throws Exception;
}
