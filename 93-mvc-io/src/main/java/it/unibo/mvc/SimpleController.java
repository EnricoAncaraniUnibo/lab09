package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 
 *
 */
public final class SimpleController implements Controller {
    private String string;
    private final List<String> history;

    public SimpleController() {
        history = new ArrayList<>();
    }

    @Override
    public void setNextPrint(String s) throws NullPointerException {
        this.string = Objects.requireNonNull(s);
    }

    @Override
    public String getNextPrint() {
        return this.string;
    }

    @Override
    public List<String> getHistoryPrint() {
        return history;
    }

    @Override
    public void show() throws IllegalStateException {
        try {
            Objects.requireNonNull(string);
        } catch (Exception e) {
            throw new IllegalStateException();
        }
        System.out.println(string);
        this.history.add(string);
        string = null;
    }
}
