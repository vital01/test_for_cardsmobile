package com.test.task.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.test.task.util.Constants;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = RequestInt.class, name = Constants.REQUEST_TYPE_INT),
        @JsonSubTypes.Type(value = RequestString.class, name = Constants.REQUEST_TYPE_STR)
})
@Document(collection = "req")
public class Request implements Serializable {

    @Id
    private Long id;

    protected Request() {
    }

    protected Request(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                '}';
    }
}
