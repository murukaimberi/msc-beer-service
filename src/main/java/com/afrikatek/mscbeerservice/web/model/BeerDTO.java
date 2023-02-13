package com.afrikatek.mscbeerservice.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * project msc-beer-service
 * created by murukai
 * created on 2023/02/13 at 03:52:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BeerDTO {
    private UUID id;
    private Integer version;
    private OffsetDateTime createdDate;
    private OffsetDateTime lastModifiedDate;
    private String beerName;
    private BeetStyleEnum beetStyle;
    private Long upc;
    private BigDecimal price;
    private Integer quantityOnHand;
}
