package com.vocabulary.vocabularymetricsbackend.metrics.vocabulary.service;

import com.vocabulary.vocabularymetricsbackend.metrics.vocabulary.dto.CommentDto;
import com.vocabulary.vocabularymetricsbackend.metrics.vocabulary.repository.VocabularyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private VocabularyRepository vocabularyRepository;

    public List<CommentDto> getQuantityOfCommentsAdded() {
        List<CommentDto> commentDtoList = new ArrayList<>();
        vocabularyRepository.findAllDistinctDate().forEach(date ->
            commentDtoList.add(new CommentDto(date, vocabularyRepository.quantityOfCommentsAddedByDay(date)))
        );
        return commentDtoList;
    }

    public List<CommentDto> getQuantityOfCommentsAddedByWeek(LocalDate minDate, LocalDate maxDate, List<CommentDto> commentDtoList) {
        Period period = Period.between(minDate, maxDate);
        boolean isLessOrEqualThanAWeek = period.getDays() <= 7 && period.getMonths() == 0 && period.getYears() == 0;

        if (isLessOrEqualThanAWeek)
            commentDtoList.add(new CommentDto(maxDate, vocabularyRepository.quantityOfCommentsAddedByWeek(minDate, maxDate)));
        else {
            final Long filterByWeeks = new Long(1);
            LocalDate maxLimitDate = minDate.plusWeeks(filterByWeeks);
            commentDtoList.add(new CommentDto(maxLimitDate, vocabularyRepository.quantityOfCommentsAddedByWeek(minDate, maxLimitDate)));
            LocalDate newMinDate = maxLimitDate;
            getQuantityOfCommentsAddedByWeek(newMinDate, maxDate, commentDtoList);
        }
        return commentDtoList;
    }
}
