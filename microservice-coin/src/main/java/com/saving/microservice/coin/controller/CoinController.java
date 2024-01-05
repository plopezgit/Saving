package com.saving.microservice.coin.controller;

import java.util.HashMap;
import com.saving.microservice.coin.entity.Coin;
import com.saving.microservice.coin.service.CoinService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.List;

@RestController
@RequestMapping("coins")
public class CoinController {

    private CoinService coinService;

    @PostMapping
    public ResponseEntity<Coin> createCoin (@RequestBody Coin coin ) throws ServerException {
        Coin newCoin = coinService.createCoin(coin);
        if (newCoin == null) {
            throw new ServerException("There is server exception error, please try again later.");
        } else {
            return new ResponseEntity<>(newCoin, HttpStatus.CREATED);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Coin> updateCoin (@PathVariable Long id, @RequestBody Coin coin) {
        Coin thisCoin = coinService.getOneCoinById(id);
        thisCoin.setPiggyBankId(coin.getPiggyBankId());
        thisCoin.setObverse(coin.getObverse());
        thisCoin.setReverse(coin.getReverse());

        Coin updatedCoin = coinService.createCoin(thisCoin);

        return new ResponseEntity<>(updatedCoin, HttpStatus.ACCEPTED);

    }

    @DeleteMapping ("{id}")
    public ResponseEntity<HashMap<String, Boolean>> deleteCoin (@PathVariable Long id) {
        coinService.deleteCoin(id);

        HashMap<String, Boolean> coinDeletedState = new HashMap<>();
        coinDeletedState.put("Deleted", true);

        return ResponseEntity.ok(coinDeletedState);

    }

    @GetMapping ("{id}")
    public ResponseEntity<Coin> getOneCoinByID (@PathVariable Long id) {
        Coin thisCoin = coinService.getOneCoinById(id);
        return ResponseEntity.ok(thisCoin);
    }

    @GetMapping
    public ResponseEntity<List<Coin>> getAllCoins () {
        return ResponseEntity.ok(coinService.getAllCoins());
    }

    @GetMapping("/search-by-piggyBank/{id}")
    public ResponseEntity<?> findAllCoinsByPiggyBankId (@PathVariable Long id) {
        return ResponseEntity.ok(coinService.getCoinByPiggyBankId(id));
    }

}
