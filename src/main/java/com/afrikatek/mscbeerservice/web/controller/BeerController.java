package com.afrikatek.mscbeerservice.web.controller;

import com.afrikatek.mscbeerservice.web.model.BeerDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * project msc-beer-service
 * created by murukai
 * created on 2023/02/13 at 04:03:45
 */
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDTO> getBeerById(@PathVariable("beerId") UUID beerId){
        //TODO impl read business logic
        return new ResponseEntity<>(BeerDTO.builder().build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewBeer(@Valid @RequestBody BeerDTO beerDTO){
        // TODO add implementation
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateBeerById(@Valid @PathVariable UUID beerId, @RequestBody BeerDTO beerDTO){
        // TODO add implementation
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
