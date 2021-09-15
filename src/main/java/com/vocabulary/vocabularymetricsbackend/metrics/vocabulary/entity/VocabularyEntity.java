package com.vocabulary.vocabularymetricsbackend.metrics.vocabulary.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "vocabulary_metrics")
public class VocabularyEntity {

    @Id
    @GeneratedValue
    private UUID id;

    private UUID vocabularyId;
    private LocalDate date = LocalDate.now();
}
