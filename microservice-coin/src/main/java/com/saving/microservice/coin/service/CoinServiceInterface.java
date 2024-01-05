package com.saving.microservice.coin.service;

import java.util.*;
import com.saving.microservice.coin.entity.Coin;

public interface CoinServiceInterface {

    Coin createCoin(Coin coin);
    void deleteCoin(Long id);
    Coin getOneCoinById(Long id);
    List<Coin> getAllCoins();
    List<Coin> getCoinByPiggyBankId(Long id);
}
