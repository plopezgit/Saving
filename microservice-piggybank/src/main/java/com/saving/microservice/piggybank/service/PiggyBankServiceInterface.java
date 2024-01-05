package com.saving.microservice.piggybank.service;

import com.saving.microservice.piggybank.entity.PiggyBank;
import com.saving.microservice.piggybank.http.response.CoinByPiggyIDResponse;

import java.util.List;

public interface PiggyBankServiceInterface {

    PiggyBank createPiggy(PiggyBank piggy);
    void deletePiggy(Long id);
    PiggyBank getOnePiggyById(Long id);
    List<PiggyBank> getAllPiggies();
    CoinByPiggyIDResponse findCoinsByPiggyId(Long id);
}
