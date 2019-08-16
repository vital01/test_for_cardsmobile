package com.test.task.db;

import com.test.task.model.Request;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface IRequestRepository extends MongoRepository<Request, Long> {

    public Optional<Request> findById(Long id);
}

