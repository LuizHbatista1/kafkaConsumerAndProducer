package com.Consumer.ConsumerApp.service;

import com.Consumer.ConsumerApp.DTOS.ProposalDTO;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ProposalConsumerService {


    private static final Logger logger = LoggerFactory.getLogger(ProposalConsumerService.class);

    @Value(value = "${topic.name}")
    private String topicName;
    @Value(value = "${spring.kafka.group-id}")
    private String groupId;

    @KafkaListener(topics = "${topic.name}" , groupId = "${spring.kafka.group-id}" , containerFactory = "kafkaListenerContainerFactory")
    public void listenTopic(ConsumerRecord<String , ProposalDTO> record){

        logger.info("Received message" + record.partition());
        logger.info("Received message" + record.value());

    }


}
