package com.test.task.model;

public class RequestInt extends Request {

    private int intField;

    public RequestInt() {
    }

    public RequestInt(Long id, int intField) {
        super(id);
        this.intField = intField;
    }

    public int getIntField() {
        return intField;
    }

    public void setIntField(int intField) {
        this.intField = intField;
    }

    @Override
    public String toString() {
        return "RequestInt{" +
                "id=" + getId() +
                ",intField=" + getIntField() +
                '}';
    }
}
