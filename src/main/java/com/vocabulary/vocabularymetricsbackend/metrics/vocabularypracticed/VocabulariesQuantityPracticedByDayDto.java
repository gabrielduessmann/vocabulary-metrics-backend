package com.vocabulary.vocabularymetricsbackend.metrics.vocabularypracticed;

import lombok.NoArgsConstructor;
import java.time.LocalDate;

@NoArgsConstructor
public class VocabulariesQuantityPracticedByDayDto {
    public LocalDate date;
    public Long quantityOfVocabulariesPracticed;
}
