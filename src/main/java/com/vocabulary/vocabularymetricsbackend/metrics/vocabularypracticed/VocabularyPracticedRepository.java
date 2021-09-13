package com.vocabulary.vocabularymetricsbackend.metrics.vocabularypracticed;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface VocabularyPracticedRepository extends CrudRepository<VocabularyPracticedEntity, UUID> {

    @Query("select distinct v.date from VocabularyPracticedEntity v order by v.date asc")
    List<LocalDate> findAllDistinctDate();

    @Query("select count(v) from VocabularyPracticedEntity v where v.date = ?1")
    Long quantityOfVocabulariesByDay(LocalDate date);
}
