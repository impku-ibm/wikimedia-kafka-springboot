package org.pankaj;

import org.pankaj.entity.WikimediaData;
import org.pankaj.repository.WikimediaDatRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {
    private static final Logger log = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);


    private WikimediaDatRepository repository;

    public KafkaDatabaseConsumer(WikimediaDatRepository repository) {
        this.repository = repository;
    }

    @KafkaListener(topics = "wikimedia_recentchange",groupId = "myGroup")
    public void consume(String eventMessage){
log.info(String.format("Event message recieved -> %s" , eventMessage));
        WikimediaData wikimediaData=new WikimediaData();
        wikimediaData.setWikieventdata(eventMessage);
        repository.save(wikimediaData);
    }
}
