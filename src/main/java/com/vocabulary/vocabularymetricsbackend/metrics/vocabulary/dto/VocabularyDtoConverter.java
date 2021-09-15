package com.vocabulary.vocabularymetricsbackend.metrics.vocabulary.dto;

import com.vocabulary.vocabularymetricsbackend.metrics.vocabulary.entity.VocabularyEntity;
import dto.VocabularyPracticedDto;

public class VocabularyDtoConverter {
    public static VocabularyEntity toEntity(VocabularyPracticedDto dto) {
        VocabularyEntity entity = new VocabularyEntity();
        entity.setVocabularyId(dto.vocabularyId);
        return entity;
    }
}
