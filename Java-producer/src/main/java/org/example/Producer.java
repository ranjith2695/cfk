package org.example;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.logging.Logger;

public class Producer {
//    private static final Logger log = (Logger) LoggerFactory.getLogger(Producer.class.getSimpleName());

    public static void main(String[] args) {
//        log.info("Working fine");



        Properties prop = new Properties();

        prop.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"kafka.confluent.svc.cluster.local:9071");
        prop.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        prop.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        final KafkaProducer<String, String> producer = new KafkaProducer<String, String>(prop);

        System.out.println("started");
//        for (int i=100;i<=150;i++){
//            ProducerRecord<String, String> record = new ProducerRecord<>("test1" , "key2" , Integer.toString(i));
//            producer.send(record);
////            log.info("hello");
//        }
        int data = 100;
        while (data<=150){
            ProducerRecord<String, String> record = new ProducerRecord<>("test1" , "key2" , Integer.toString(data));
            producer.send(record);
            data++;
            producer.flush();
            System.out.println("flushed");
        }
    }

}
