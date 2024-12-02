package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {
    public void setNextPrint(String s) throws NullPointerException;

    public String getNextPrint();

    public List<String> getHistoryPrint();

    public void show() throws IllegalStateException;
}
