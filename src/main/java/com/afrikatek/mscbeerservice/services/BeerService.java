package com.afrikatek.mscbeerservice.services;

import com.afrikatek.mscbeerservice.web.model.BeerDTO;

import java.util.UUID;

/**
 * project msc-beer-service
 * created by murukai
 * created on 2023/03/11 at 06:33:14
 */
public interface BeerService {
    BeerDTO getById(UUID beerId);

    BeerDTO createNewBeer(BeerDTO beerDTO);

    BeerDTO updateBeer(UUID beerId, BeerDTO beerDTO);
}
