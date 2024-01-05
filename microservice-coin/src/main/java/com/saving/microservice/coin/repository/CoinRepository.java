package com.saving.microservice.coin.repository;

import com.saving.microservice.coin.entity.Coin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoinRepository extends MongoRepository<Coin, Integer> {

}
