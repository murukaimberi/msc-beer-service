package com.afrikatek.mscbeerservice.bootstrap;

import com.afrikatek.mscbeerservice.domain.Beer;
import com.afrikatek.mscbeerservice.repositories.BeerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * project msc-beer-service
 * created by murukai
 * created on 2023/03/07 at 15:06:53
 */
@AllArgsConstructor
@Slf4j
@Component
public class BeerLoader implements CommandLineRunner {
    private final BeerRepository beerRepository;
    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if(beerRepository.count() == 0){
            beerRepository.save(
                    Beer.builder()
                            .beerName("Mango Bobs")
                            .beerStyle("IPA")
                            .quantityToBrew(200)
                            .minOnHand(12)
                            .upc("337010000001")
                            .price(new BigDecimal("12.95"))
                            .build()
            );

            beerRepository.save(
                    Beer.builder()
                            .beerName("Galary Cats")
                            .beerStyle("PALE_ALE")
                            .quantityToBrew(200)
                            .minOnHand(12)
                            .upc("337010000002")
                            .price(new BigDecimal("11.95"))
                            .build()
            );

            log.error("BEERS ARE " + beerRepository.count());
        }
    }
}
