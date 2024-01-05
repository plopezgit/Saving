package com.saving.microservice.piggybank.service;

import com.saving.microservice.piggybank.entity.PiggyBank;
import com.saving.microservice.piggybank.repository.PiggyBankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PiggyBankService implements PiggyBankServiceInterface{

    @Autowired
    PiggyBankRepository piggies;

    @Override
    public PiggyBank createPiggy(PiggyBank piggy) {
        return piggies.save(piggy);
    }

    @Override
    public void deletePiggy(int id) {
        piggies.deleteById(id);
    }

    @Override
    public PiggyBank getOnePiggyById(int id) {
        Optional<PiggyBank> optionalPiggy = piggies.findById(id);
        return optionalPiggy.get();
    }

    @Override
    public List<PiggyBank> getAllPiggies() {
        return piggies.findAll();
    }
}
