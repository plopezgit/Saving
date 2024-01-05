package com.saving.microservice.piggybank.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CoinDTO {
    private Long piggyBankId;
    private String obverse;
    private String reverse;
}
