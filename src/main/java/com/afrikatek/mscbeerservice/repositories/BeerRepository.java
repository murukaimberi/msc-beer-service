package com.afrikatek.mscbeerservice.repositories;

import com.afrikatek.mscbeerservice.domain.Beer;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * project msc-beer-service
 * created by murukai
 * created on 2023/03/07 at 15:02:40
 */
public interface BeerRepository extends CrudRepository<Beer, UUID> {
}
