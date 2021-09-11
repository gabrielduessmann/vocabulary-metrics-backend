package com.vocabulary.vocabularymetricsbackend.metrics.vocabularypracticed;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
public class VocabularyPracticedEntity {

    @Id
    @GeneratedValue
    private UUID id;

    private UUID vocabularyId;
    private Date actionDate = new Date();
}
