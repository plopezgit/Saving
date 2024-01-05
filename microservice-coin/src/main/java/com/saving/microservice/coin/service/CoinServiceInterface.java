package com.saving.microservice.coin.service;

import java.util.*;
import com.saving.microservice.coin.entity.Coin;

public interface CoinServiceInterface {

    Coin createCoin(Coin coin);
    void deleteCoin(long id);
    Coin getOneCoinById(long id);
    List<Coin> getAllCoins();
    List<Coin> getCoinByPiggyBankId(long id);
}
