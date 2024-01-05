package com.saving.microservice.piggybank.http.response;

import com.saving.microservice.piggybank.controller.CoinDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CoinByPiggyIDResponse {
    private String character;
    private String mood;
    private List<CoinDTO> coinDTOList;
}
