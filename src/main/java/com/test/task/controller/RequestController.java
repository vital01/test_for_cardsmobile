package com.test.task.controller;

import com.test.task.conf.RabbitConfiguration;
import com.test.task.model.Request;
import com.test.task.service.IRequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/request")
public class RequestController {

    private Logger logger = LoggerFactory.getLogger(RequestController.class);

    @Autowired
    private RabbitTemplate rabbit;

    @Autowired
    private IRequestService reqService;

    @PostMapping("/add")
    public ResponseEntity addRequest(@RequestBody Request request) {
        try {
            logger.info("Request received (" + request.getClass().getSimpleName() + ")");
            rabbit.convertAndSend(RabbitConfiguration.REQUEST_QUEUE, request);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            logger.error("Exception during adding request", ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Request> getRequest(@PathVariable("id") Long id) {
        try {
            Optional<Request> req = reqService.getRequestById(id);
            if (req.isPresent()) {
                logger.info("Request found " + req.get().getClass().getSimpleName() + " with ID [" + id + "]");
                return ResponseEntity.ok(req.get());
            } else {
                logger.warn("Request found with ID [" + id + "] not found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception ex) {
            logger.error("Exception during getting request", ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}


