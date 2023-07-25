package in.kafka.springboot;

import in.kafka.springboot.Repository.wikimediaDataRepository;
import in.kafka.springboot.entity.wikimediaData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class kafkaDatabaseConsumer {
    private static final Logger LOGGER= LoggerFactory.getLogger(kafkaDatabaseConsumer.class);
    //declare jpa repository inject wikimediaDataRepository
    private wikimediaDataRepository dataRepository;

    public kafkaDatabaseConsumer(wikimediaDataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }




    @KafkaListener(topics = "${spring.kafka.topic.name}",groupId = "myGroup")
    public void consume(String eventMessage){
        LOGGER.info(String.format("Event message received -> %s",eventMessage));

        //now lets call save method to save the event message
        wikimediaData wikimediaData=new wikimediaData();
        wikimediaData.setWikiEventData(eventMessage);
        dataRepository.save(wikimediaData);
    }
}
