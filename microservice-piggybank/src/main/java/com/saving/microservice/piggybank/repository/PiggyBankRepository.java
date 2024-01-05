package com.saving.microservice.piggybank.repository;

import com.saving.microservice.piggybank.entity.PiggyBank;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PiggyBankRepository extends MongoRepository<PiggyBank, Long> {

}
