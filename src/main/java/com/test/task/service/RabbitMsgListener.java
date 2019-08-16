package com.test.task.service;

import com.test.task.conf.RabbitConfiguration;
import com.test.task.model.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMsgListener {

    private Logger logger = LoggerFactory.getLogger(RabbitMsgListener.class);

    @Autowired
    private IRequestService reqService;

    @RabbitListener(queues = RabbitConfiguration.REQUEST_QUEUE)
    public void receiveRequest(Request req) {
        logger.debug("Get request from queue: " + req);
        try {
            reqService.addRequest(req);
        } catch (Exception ex) {
            logger.error("Error during processing and saving request", ex);
        }
    }

}
