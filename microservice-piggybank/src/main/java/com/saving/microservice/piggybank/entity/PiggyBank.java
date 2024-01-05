package com.saving.microservice.piggybank.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection="piggybanks")
public class PiggyBank {
    private Long id;
    private int capacity;
    private String character;
    private String mood;
}
