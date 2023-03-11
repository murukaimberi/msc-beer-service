package com.afrikatek.mscbeerservice.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;
import lombok.*;

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
    @Null
    private UUID id;
    @Null
    private Integer version;
    @Null
    private OffsetDateTime createdDate;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
    @Null
    private OffsetDateTime lastModifiedDate;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
    @NotBlank
    private String beerName;
    @NotNull
    private BeetStyleEnum beetStyle;
    @NotNull
    @Positive
    private Long upc;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @NotNull
    @Positive
    private BigDecimal price;
    private Integer quantityOnHand;
}
