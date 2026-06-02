package org.TaskManager;

public class Task {

    private String name;
    private boolean done;
    public Task(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Be sure to fulfill the blanks properly");
        }

        this.name = name;
        this.done = false;
    }
    public Task(String name, boolean done) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Be sure to fulfill the blanks properly");
        }

        this.name = name;
        this.done = done;
    }
    public String getName() {
        return name;
    }
    public boolean isDone() {
        return done;
    }
    public void setDone() {
        if (done) {
            throw new IllegalArgumentException("Already done");
        }

        this.done = true;
    }
    public void unDone() {
        if (!done) {
            throw new IllegalArgumentException("Yet to be done");
        }

        this.done = false;
    }
}