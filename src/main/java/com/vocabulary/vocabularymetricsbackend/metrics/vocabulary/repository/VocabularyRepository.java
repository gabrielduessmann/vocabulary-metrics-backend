package com.vocabulary.vocabularymetricsbackend.metrics.vocabulary.repository;

import com.vocabulary.vocabularymetricsbackend.metrics.vocabulary.entity.VocabularyEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface VocabularyRepository extends CrudRepository<VocabularyEntity, UUID> {

    @Query("select distinct v.date from VocabularyEntity v order by v.date asc")
    List<LocalDate> findAllDistinctDate();

    @Query("select count(v) from VocabularyEntity v where v.date = ?1")
    Long quantityOfCommentsAddedByDay(LocalDate date);

    @Query("select count(distinct v.vocabularyId) from VocabularyEntity v where v.date = ?1")
    Long quantityOfVocabulariesPracticedByDay(LocalDate date);
}
