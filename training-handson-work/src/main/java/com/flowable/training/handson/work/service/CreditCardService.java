package com.flowable.training.handson.work.service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service("creditCardService")
public class CreditCardService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreditCardService.class);

    private final ObjectMapper objectMapper = new ObjectMapper();

    public ObjectNode charge(String creditCardNumber, double amount) {
        String transactionNumber = UUID.randomUUID().toString();
        double fee = amount * 0.05;

        LOGGER.info(
                "Processing credit card transaction with card number={}, amount={}; using transaction number={} and fee={}",
                creditCardNumber,
                amount,
                transactionNumber,
                fee
        );

        ObjectNode result = objectMapper.createObjectNode();
        result.put("transactionNumber", transactionNumber);
        result.put("fee", fee);
        return result;
    }

}
