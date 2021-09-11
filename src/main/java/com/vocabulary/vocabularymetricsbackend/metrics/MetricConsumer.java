package com.vocabulary.vocabularymetricsbackend.metrics;

import com.vocabulary.vocabularymetricsbackend.metrics.vocabularypracticed.VocabularyPracticedService;
import dto.VocabularyPracticedDto;
import messagebroker.RabbitMQConstants;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MetricConsumer {

    @Autowired
    private VocabularyPracticedService vocabularyPracticedService;

    @RabbitListener(queues = RabbitMQConstants.VOCABULARY_QUEUE)
    private void consumer(VocabularyPracticedDto vocabularyPracticedDto) {
        vocabularyPracticedService.save(vocabularyPracticedDto);
    }
}
