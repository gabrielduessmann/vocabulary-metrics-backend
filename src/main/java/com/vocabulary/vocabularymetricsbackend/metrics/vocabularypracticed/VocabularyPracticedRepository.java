package com.vocabulary.vocabularymetricsbackend.metrics.vocabularypracticed;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface VocabularyPracticedRepository extends CrudRepository<VocabularyPracticedEntity, UUID> {
}
