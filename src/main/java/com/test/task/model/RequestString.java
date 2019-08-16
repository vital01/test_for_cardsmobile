package com.test.task.model;

public class RequestString extends Request {

    private String strField;

    public RequestString() {
    }

    public RequestString(Long id, String strField) {
        super(id);
        this.strField = strField;
    }

    public String getStrField() {
        return strField;
    }

    public void setStrField(String strField) {
        this.strField = strField;
    }

    @Override
    public String toString() {
        return "RequestString{" +
                "id=" + getId() +
                "strField='" + getStrField() + '\'' +
                '}';
    }
}
