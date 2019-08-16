package com.test.task.service;

import com.test.task.model.Request;

import java.util.Optional;

public interface IRequestService {

    public void addRequest(Request req) throws Exception;

    public Optional<Request> getRequestById(Long id);
}
