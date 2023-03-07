package com.afrikatek.mscbeerservice.web.mappers;

import com.afrikatek.mscbeerservice.domain.Beer;
import com.afrikatek.mscbeerservice.web.model.BeerDTO;
import org.mapstruct.Mapper;

/**
 * project msc-beer-service
 * created by murukai
 * created on 2023/03/07 at 19:05:42
 */
@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
    BeerDTO beerToBeerDTO(Beer beer);
    Beer beerDTOToBeer(BeerDTO beerDTO);
}
