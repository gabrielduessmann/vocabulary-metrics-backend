package com.vocabulary.vocabularymetricsbackend.comment;

import dto.CommentDTO;
import messagebroker.RabbitMQConstants;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class CommentConsumer {

    @RabbitListener(queues = RabbitMQConstants.VOCABULARY_QUEUE)
    private void consumer(CommentDTO commentDTO) {
        System.out.println(commentDTO.comment);
        System.out.println(commentDTO.id);
    }
}
