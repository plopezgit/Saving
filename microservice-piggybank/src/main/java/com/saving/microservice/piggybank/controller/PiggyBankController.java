package com.saving.microservice.piggybank.controller;

import com.saving.microservice.piggybank.entity.PiggyBank;
import com.saving.microservice.piggybank.service.PiggyBankService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("piggies")
public class PiggyBankController {

    private PiggyBankService piggyService;

    @PostMapping
    public ResponseEntity<PiggyBank> createCoin (@RequestBody PiggyBank piggy ) throws ServerException {
        PiggyBank newPiggy = piggyService.createPiggy(piggy);
        if (newPiggy == null) {
            throw new ServerException("There is server exception error, please try again later.");
        } else {
            return new ResponseEntity<>(newPiggy, HttpStatus.CREATED);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<PiggyBank> updateCoin (@PathVariable int id, @RequestBody PiggyBank piggy) {
        PiggyBank thisPiggy = piggyService.getOnePiggyById(id);
        thisPiggy.setCapacity(piggy.getCapacity());
        thisPiggy.setCharacter(piggy.getCharacter());
        thisPiggy.setMood(piggy.getMood());

        PiggyBank updatedPiggy = piggyService.createPiggy(thisPiggy);

        return new ResponseEntity<>(updatedPiggy, HttpStatus.ACCEPTED);

    }

    @DeleteMapping ("{id}")
    public ResponseEntity<HashMap<String, Boolean>> deletePiggy (@PathVariable int id) {
        piggyService.deletePiggy(id);

        HashMap<String, Boolean> piggyDeletedState = new HashMap<>();
        piggyDeletedState.put("Deleted", true);

        return ResponseEntity.ok(piggyDeletedState);

    }

    @GetMapping ("{id}")
    public ResponseEntity<PiggyBank> getOneCoinByID (@PathVariable int id) {
        PiggyBank thisPiggy = piggyService.getOnePiggyById(id);
        return ResponseEntity.ok(thisPiggy);
    }

    @GetMapping
    public ResponseEntity<List<PiggyBank>> getAllCoins () {
        return ResponseEntity.ok(piggyService.getAllPiggies());
    }

}
