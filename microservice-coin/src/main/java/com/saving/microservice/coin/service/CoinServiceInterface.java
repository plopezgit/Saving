package com.saving.microservice.coin.service;

import java.util.*;
import com.saving.microservice.coin.entity.Coin;

public interface CoinServiceInterface {

    Coin createCoin(Coin coin);
    void deleteCoin(int id);
    Coin getOneCoinById(int id);
    List<Coin> getAllCoins();
    /*public void insertACoinOnAPiggyBank(int coinDd, int piggyBankId);*/
}
