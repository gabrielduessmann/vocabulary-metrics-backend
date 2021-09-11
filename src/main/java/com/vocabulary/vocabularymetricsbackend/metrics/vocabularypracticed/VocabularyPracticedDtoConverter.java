package com.vocabulary.vocabularymetricsbackend.metrics.vocabularypracticed;

import dto.VocabularyPracticedDto;

public class VocabularyPracticedDtoConverter {
    public static VocabularyPracticedEntity toEntity(VocabularyPracticedDto dto) {
        VocabularyPracticedEntity entity = new VocabularyPracticedEntity();
        entity.setVocabularyId(dto.vocabularyId);
        return entity;
    }
}
