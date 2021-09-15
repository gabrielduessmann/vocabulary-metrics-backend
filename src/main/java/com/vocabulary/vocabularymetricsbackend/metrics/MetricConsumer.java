package com.vocabulary.vocabularymetricsbackend.metrics;

import com.vocabulary.vocabularymetricsbackend.metrics.vocabulary.service.VocabularyService;
import dto.VocabularyPracticedDto;
import messagebroker.RabbitMQConstants;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MetricConsumer {

    @Autowired
    private VocabularyService vocabularyService;

    @RabbitListener(queues = RabbitMQConstants.VOCABULARY_QUEUE)
    private void consumer(VocabularyPracticedDto vocabularyPracticedDto) {
        vocabularyService.save(vocabularyPracticedDto);
    }
}
