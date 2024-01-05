package com.saving.microservice.piggybank.service;

import com.saving.microservice.piggybank.entity.PiggyBank;

import java.util.List;

public interface PiggyBankServiceInterface {

    PiggyBank createPiggy(PiggyBank piggy);
    void deletePiggy(int id);
    PiggyBank getOnePiggyById(int id);
    List<PiggyBank> getAllPiggies();
}
