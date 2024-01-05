package com.saving.microservice.coin.repository;

import com.saving.microservice.coin.entity.Coin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoinRepository extends MongoRepository<Coin, Long> {
    List<Coin> findAllCoinsByPiggyBankID (Long id);
}
