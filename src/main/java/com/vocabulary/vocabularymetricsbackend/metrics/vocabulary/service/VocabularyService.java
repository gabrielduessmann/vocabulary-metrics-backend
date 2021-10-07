package com.vocabulary.vocabularymetricsbackend.metrics.vocabulary.service;

import com.vocabulary.vocabularymetricsbackend.metrics.vocabulary.dto.VocabularyDto;
import com.vocabulary.vocabularymetricsbackend.metrics.vocabulary.dto.VocabularyDtoConverter;
import com.vocabulary.vocabularymetricsbackend.metrics.vocabulary.repository.VocabularyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Period;
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
        vocabularyRepository.findAllDistinctDate().forEach(date ->
                vocabularyDtoList.add(new VocabularyDto(date, vocabularyRepository.quantityOfVocabulariesPracticedByDay(date)))
        );
        return vocabularyDtoList;
    }

    public List<VocabularyDto> getQuantityOfVocabulariesPracticedByWeek(LocalDate minDate, LocalDate maxDate, List<VocabularyDto> commentDtoList) {
        Period period = Period.between(minDate, maxDate);
        boolean isLessOrEqualThanAWeek = period.getDays() <= 7 && period.getMonths() == 0 && period.getYears() == 0;

        if (isLessOrEqualThanAWeek)
            commentDtoList.add(new VocabularyDto(maxDate, vocabularyRepository.quantityOfVocabulariesPracticedByWeek(minDate, maxDate)));
        else {
            final Long filterByWeeks = new Long(1);
            LocalDate maxLimitDate = minDate.plusWeeks(filterByWeeks);
            commentDtoList.add(new VocabularyDto(maxLimitDate, vocabularyRepository.quantityOfVocabulariesPracticedByWeek(minDate, maxLimitDate)));
            LocalDate newMinDate = maxLimitDate;
            getQuantityOfVocabulariesPracticedByWeek(newMinDate, maxDate, commentDtoList);
        }
        return commentDtoList;
    }

}
