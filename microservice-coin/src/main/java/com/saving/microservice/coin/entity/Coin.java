package com.saving.microservice.coin.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection="coins")
public class Coin {
    private long id;
    private long piggyBankId;
    private String obverse;
    private String reverse;
}
