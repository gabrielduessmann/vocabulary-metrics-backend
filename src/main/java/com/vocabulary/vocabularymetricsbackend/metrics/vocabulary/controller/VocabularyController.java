package com.vocabulary.vocabularymetricsbackend.metrics.vocabulary.controller;


import com.vocabulary.vocabularymetricsbackend.metrics.vocabulary.dto.CommentDto;
import com.vocabulary.vocabularymetricsbackend.metrics.vocabulary.dto.VocabularyDto;
import com.vocabulary.vocabularymetricsbackend.metrics.vocabulary.service.CommentService;
import com.vocabulary.vocabularymetricsbackend.metrics.vocabulary.service.VocabularyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class VocabularyController {

    @Autowired
    private VocabularyService vocabularyService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/metrics/vocabularies")
    public List<VocabularyDto> getVocabularyMetrics() {
        return vocabularyService.getQuantityOfVocabulariesPracticed();
    }

    @GetMapping("/metrics/comments")
    public List<CommentDto> getCommentMetrics() {
        return commentService.getQuantityOfCommentsAdded();
    }
}
