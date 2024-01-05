package com.saving.microservice.piggybank.service;

import com.saving.microservice.piggybank.client.CoinClient;
import com.saving.microservice.piggybank.controller.CoinDTO;
import com.saving.microservice.piggybank.entity.PiggyBank;
import com.saving.microservice.piggybank.http.response.CoinByPiggyIDResponse;
import com.saving.microservice.piggybank.repository.PiggyBankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PiggyBankService implements PiggyBankServiceInterface{

    @Autowired
    private PiggyBankRepository piggies;
    private CoinClient coinClient;

    @Override
    public PiggyBank createPiggy(PiggyBank piggy) {
        return piggies.save(piggy);
    }

    @Override
    public void deletePiggy(Long id) {
        piggies.deleteById(id);
    }

    @Override
    public PiggyBank getOnePiggyById(Long id) {
        Optional<PiggyBank> optionalPiggy = piggies.findById(id);
        return optionalPiggy.get();
    }

    @Override
    public List<PiggyBank> getAllPiggies() {
        return piggies.findAll();
    }

    @Override
    public CoinByPiggyIDResponse findCoinsByPiggyId(Long id) {
        PiggyBank thisPiggy = piggies.findById(id).orElse(null);
        List<CoinDTO> coinDTOList = coinClient.findAllCoinsByPiggyBankId(id);
        return CoinByPiggyIDResponse.builder()
                .character(thisPiggy.getCharacter())
                .mood(thisPiggy.getMood())
                .coinDTOList(coinDTOList)
                .build();
    }
}
