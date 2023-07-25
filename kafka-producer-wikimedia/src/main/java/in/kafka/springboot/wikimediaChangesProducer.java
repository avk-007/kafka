package in.kafka.springboot;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;
@Service
public class wikimediaChangesProducer {
    public static final Logger LOGGER = LoggerFactory.getLogger(wikimediaChangesProducer.class);

    private KafkaTemplate<String,String> kafkaTemplate;

    public wikimediaChangesProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    //create a method to read

    public void sendMessage() throws InterruptedException {
        String topic="wikimediaRecentChange";
        //to read realtime stream data from wikimedia we use event source & add okhttp event source dependency
             //https://stream.wikimedia.org/v2/stream/recentchange
        EventHandler eventHandler=new wikimediaChangesHandler(kafkaTemplate,topic);
        String url="https://stream.wikimedia.org/v2/stream/recentchange";
        EventSource.Builder builder=new EventSource.Builder(eventHandler, URI.create(url));
        EventSource eventSource = builder.build();
        eventSource.start();
        TimeUnit.MINUTES.sleep(10);

    }
}

