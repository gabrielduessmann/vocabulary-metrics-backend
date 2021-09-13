package com.vocabulary.vocabularymetricsbackend.metrics.vocabularypracticed;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class VocabularyPracticedController {

    @Autowired
    private VocabularyPracticedService vocabularyPracticedService;

    @GetMapping("/vocabulary-metrics/day")
    public List<VocabulariesQuantityPracticedByDayDto> getVocabulariesQuantityPracticedByDay() {
        return vocabularyPracticedService.getVocabulariesQuantityPracticedByDay();
    }
}
