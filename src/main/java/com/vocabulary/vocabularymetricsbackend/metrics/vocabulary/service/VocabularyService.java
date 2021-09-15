package com.vocabulary.vocabularymetricsbackend.metrics.vocabulary.service;

import com.vocabulary.vocabularymetricsbackend.metrics.vocabulary.dto.VocabularyDto;
import com.vocabulary.vocabularymetricsbackend.metrics.vocabulary.dto.VocabularyDtoConverter;
import com.vocabulary.vocabularymetricsbackend.metrics.vocabulary.repository.VocabularyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class VocabularyService {

    @Autowired
    private VocabularyRepository vocabularyRepository;

    public void save(dto.VocabularyPracticedDto dto) {
        vocabularyRepository.save(VocabularyDtoConverter.toEntity(dto));
    }

    public List<VocabularyDto> getQuantityOfVocabulariesPracticed() {
        List<VocabularyDto> vocabularyDtoList = new ArrayList<>();
        vocabularyRepository.findAllDistinctDate().forEach(date -> {

            VocabularyDto vocabularyDto = new VocabularyDto();
            vocabularyDto.date = date;
            vocabularyDto.quantityOfVocabulariesPracticed = vocabularyRepository.quantityOfVocabulariesPracticedByDay(date);
            vocabularyDtoList.add(vocabularyDto);
        });
        return vocabularyDtoList;
    }

}
