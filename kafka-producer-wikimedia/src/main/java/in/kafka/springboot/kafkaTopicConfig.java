package in.kafka.springboot;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class kafkaTopicConfig {
    public NewTopic topic(){
        return TopicBuilder.name("wikimediaRecentChange").build();


    }
}
