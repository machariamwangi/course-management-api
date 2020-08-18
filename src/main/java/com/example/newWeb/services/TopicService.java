package com.example.newWeb.services;

import com.example.newWeb.models.Topic;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

   private List<Topic> topics =   new ArrayList<>(Arrays.asList(
            new Topic("spring", "spring Framework", "spring description"),
            new Topic("java", "core java", "core java description"),
            new Topic("javascript", "javascript Framework", "javascript description")
    ));
    public List<Topic> getAllTopics(){
        return topics;
    }
    public Topic getTopic(String id){
      return   topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }
    public void addTopic( Topic topic){
        topics.add(topic);

    }
    public void updateTopic(String id, Topic topic){
        for (int i = 0; i < topics.size(); i++){
            Topic t = topics.get(i);
            if (t.getId().equals(id)){
                topics.set(i, topic);
                return;
            }
        }

    }
    public void  deleteTopic(String id){
        topics.removeIf(t -> t.getId().equals(id));
    }

}
