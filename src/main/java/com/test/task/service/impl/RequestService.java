package com.test.task.service.impl;

import com.test.task.db.IRequestRepository;
import com.test.task.model.Request;
import com.test.task.service.IRequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RequestService implements IRequestService {

    private Logger logger = LoggerFactory.getLogger(RequestService.class);

    @Autowired
    private IRequestRepository reqRepo;

    @Override
    public void addRequest(Request req) throws Exception {

        //todo: change to real processing
        Request processed = process(req);
        logger.debug("Processing finished: " + processed);
        reqRepo.save(processed);
        logger.info("Request saved with ID [" + processed.getId() + "]");
    }

    @Override
    public Optional<Request> getRequestById(Long id) {
        return reqRepo.findById(id);
    }


    public Request process(Request request) throws Exception {
        Thread.sleep(1000);
        return request;
    }

}
