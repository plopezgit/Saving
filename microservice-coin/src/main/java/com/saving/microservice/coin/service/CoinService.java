package com.saving.microservice.coin.service;

import com.saving.microservice.coin.entity.Coin;
import com.saving.microservice.coin.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoinService implements CoinServiceInterface {

    @Autowired
    private CoinRepository coins;
    @Override
    public Coin createCoin(Coin coin) {
        return coins.save(coin);
    }

    @Override
    public void deleteCoin(long id) {
        coins.deleteById(id);
    }

    @Override
    public Coin getOneCoinById(long id) {
        Optional<Coin> optionalCoin = coins.findById(id);
        return optionalCoin.get();
    }

    @Override
    public List<Coin> getAllCoins() {
        return coins.findAll();
    }

    @Override
    public List<Coin> getCoinByPiggyBankId(long id) {
        return coins.findAllCoinsByPiggyBankID(id);
    }

}
