package com.vocabulary.vocabularymetricsbackend.metrics.vocabularypracticed;

import dto.VocabularyPracticedDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VocabularyPracticedService {

    @Autowired
    private VocabularyPracticedRepository vocabularyPracticedRepository;

    public void save(VocabularyPracticedDto dto) {
        vocabularyPracticedRepository.save(VocabularyPracticedDtoConverter.toEntity(dto));
    }

    public List<VocabulariesQuantityPracticedByDayDto> getVocabulariesQuantityPracticedByDay() {
        List<VocabulariesQuantityPracticedByDayDto> vocabulariesQuantityDtoList = new ArrayList<>();
        vocabularyPracticedRepository.findAllDistinctDate().forEach(date -> {

            VocabulariesQuantityPracticedByDayDto vocabulariesQuantityDto = new VocabulariesQuantityPracticedByDayDto();
            vocabulariesQuantityDto.date = date;
            vocabulariesQuantityDto.quantityOfVocabulariesPracticed = vocabularyPracticedRepository.quantityOfVocabulariesByDay(date);
            vocabulariesQuantityDtoList.add(vocabulariesQuantityDto);
        });
        return vocabulariesQuantityDtoList;
    }

}
