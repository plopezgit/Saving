package com.saving.microservice.piggybank.controller;

import com.saving.microservice.piggybank.entity.PiggyBank;
import com.saving.microservice.piggybank.service.PiggyBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/piggies")
public class PiggyBankController {

    @Autowired
    private PiggyBankService piggyService;

    @PostMapping
    public ResponseEntity<PiggyBank> createPiggyBank (@RequestBody PiggyBank piggy ) throws ServerException {
        PiggyBank newPiggy = piggyService.createPiggy(piggy);
        if (newPiggy == null) {
            throw new ServerException("There is server exception error, please try again later.");
        } else {
            return new ResponseEntity<>(newPiggy, HttpStatus.CREATED);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<PiggyBank> updatePiggyBank (@PathVariable Long id, @RequestBody PiggyBank piggy) {
        PiggyBank thisPiggy = piggyService.getOnePiggyById(id);
        thisPiggy.setCapacity(piggy.getCapacity());
        thisPiggy.setCharacter(piggy.getCharacter());
        thisPiggy.setMood(piggy.getMood());

        PiggyBank updatedPiggy = piggyService.createPiggy(thisPiggy);

        return new ResponseEntity<>(updatedPiggy, HttpStatus.ACCEPTED);

    }

    @DeleteMapping ("{id}")
    public ResponseEntity<HashMap<String, Boolean>> deletePiggy (@PathVariable Long id) {
        piggyService.deletePiggy(id);

        HashMap<String, Boolean> piggyDeletedState = new HashMap<>();
        piggyDeletedState.put("Deleted", true);

        return ResponseEntity.ok(piggyDeletedState);

    }

    @GetMapping ("{id}")
    public ResponseEntity<PiggyBank> getOnePiggyBankByID (@PathVariable Long id) {
        PiggyBank thisPiggy = piggyService.getOnePiggyById(id);
        return ResponseEntity.ok(thisPiggy);
    }

    @GetMapping
    public ResponseEntity<List<PiggyBank>> getAllPiggies () {
        return ResponseEntity.ok(piggyService.getAllPiggies());
    }

    @GetMapping("/search-coins/{id}")
    public ResponseEntity<?> findCoinsByPiggyBankId(@PathVariable Long id){
        return ResponseEntity.ok(piggyService.findCoinsByPiggyId(id));
    }
}
