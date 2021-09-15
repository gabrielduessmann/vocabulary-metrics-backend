package com.vocabulary.vocabularymetricsbackend.metrics.vocabulary.service;

import com.vocabulary.vocabularymetricsbackend.metrics.vocabulary.dto.CommentDto;
import com.vocabulary.vocabularymetricsbackend.metrics.vocabulary.repository.VocabularyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private VocabularyRepository vocabularyRepository;

    public List<CommentDto> getQuantityOfCommentsAdded() {
        List<CommentDto> commentDtoList = new ArrayList<>();
        vocabularyRepository.findAllDistinctDate().forEach(date -> {
            CommentDto commentDto = new CommentDto();
            commentDto.date = date;
            commentDto.quantityOfCommentsAdded = vocabularyRepository.quantityOfCommentsAddedByDay(date);
            commentDtoList.add(commentDto);
        });
        return commentDtoList;
    }
}
