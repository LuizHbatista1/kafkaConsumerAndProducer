package com.Producer.ProducerApp.service;

import com.Producer.ProducerApp.DTOS.ProposalDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String , ProposalDTO> kafkaTemplate;
    private final String topic;
    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerService.class);

    public KafkaProducerService(@Value("${topic.name}") String topic,  KafkaTemplate<String, ProposalDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    public void sendPayload (ProposalDTO proposalDTO){

        kafkaTemplate.send(topic , proposalDTO).whenComplete((result , ex)->{

            if(ex != null ){

                logger.info("failure" + ex.getMessage());

            } else  {

                logger.info("Message send!" + result.getProducerRecord().value());

            }
        });



    }



}
