package com.vocabulary.vocabularymetricsbackend.metrics.vocabulary.dto;

import lombok.NoArgsConstructor;
import java.time.LocalDate;

@NoArgsConstructor
public class VocabularyDto {
    public LocalDate date;
    public Long quantityOfVocabulariesPracticed;
}
