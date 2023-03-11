package com.afrikatek.mscbeerservice.services.impl;

import com.afrikatek.mscbeerservice.domain.Beer;
import com.afrikatek.mscbeerservice.repositories.BeerRepository;
import com.afrikatek.mscbeerservice.services.BeerService;
import com.afrikatek.mscbeerservice.web.mappers.BeerMapper;
import com.afrikatek.mscbeerservice.web.model.BeerDTO;
import com.afrikatek.mscbeerservice.web.model.BeetStyleEnum;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * project msc-beer-service
 * created by murukai
 * created on 2023/03/11 at 06:37:48
 */
@Service
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService {
    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;
    @Override
    public BeerDTO getById(UUID beerId) {
        return beerMapper.beerToBeerDTO(
                beerRepository
                        .findById(beerId)
                        .orElseThrow(() -> new EntityNotFoundException("Beer could not be found"))
        );
    }

    @Override
    public BeerDTO createNewBeer(BeerDTO beerDTO) {
        Beer beer = beerMapper.beerDTOToBeer(beerDTO);
        return beerMapper.beerToBeerDTO(beerRepository.save(beer));
    }

    @Override
    public BeerDTO updateBeer(UUID beerId, BeerDTO beerDTO) {
        Beer beer = beerRepository.findById(beerId).orElseThrow(() -> new EntityNotFoundException("Beer could not be found"));
        beer.setBeerName(beerDTO.getBeerName());
        beer.setBeerStyle(beerDTO.getBeetStyle().name());
        beer.setPrice(beerDTO.getPrice());
        beer.setUpc(beerDTO.getUpc());
        return beerMapper.beerToBeerDTO(beerRepository.save(beer));
    }
}
