package com.vocabulary.vocabularymetricsbackend.metrics.vocabulary.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
public class VocabularyDto {
    public LocalDate date;
    public Long quantityOfVocabulariesPracticed;
}
