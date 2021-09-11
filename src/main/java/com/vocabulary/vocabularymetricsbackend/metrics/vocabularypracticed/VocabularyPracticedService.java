package com.vocabulary.vocabularymetricsbackend.metrics.vocabularypracticed;

import dto.VocabularyPracticedDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VocabularyPracticedService {

    @Autowired
    private VocabularyPracticedRepository vocabularyPracticedRepository;

    public void save(VocabularyPracticedDto dto) {
        vocabularyPracticedRepository.save(VocabularyPracticedDtoConverter.toEntity(dto));
    }
}
