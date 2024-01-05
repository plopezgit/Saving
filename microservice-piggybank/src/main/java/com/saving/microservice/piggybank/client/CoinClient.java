package com.saving.microservice.piggybank.client;

import com.saving.microservice.piggybank.controller.CoinDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="msvc-coin", url= "localhost:8080/coins")
public interface CoinClient {

    @GetMapping("/search-By-PiggyBank/{id}")
    List<CoinDTO> findAllCoinsByPiggyBankId(@PathVariable Long id);
}
