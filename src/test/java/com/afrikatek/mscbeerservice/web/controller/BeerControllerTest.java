package com.afrikatek.mscbeerservice.web.controller;

import com.afrikatek.mscbeerservice.web.model.BeerDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.PayloadDocumentation;
import org.springframework.restdocs.request.RequestDocumentation;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * project msc-beer-service
 * created by murukai
 * created on 2023/02/13 at 04:19:35
 */
@ExtendWith(RestDocumentationExtension.class)
@AutoConfigureRestDocs
@WebMvcTest(BeerController.class)
@ComponentScan(basePackages = "com.afrikatek.mscbeerservice.web.mappers")
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getBeerById() throws Exception{
        mockMvc.perform(RestDocumentationRequestBuilders.get("/api/v1/beer/{beerId}", UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andDo(MockMvcRestDocumentation.document("/v1/beer", RequestDocumentation.pathParameters(
                        RequestDocumentation.parameterWithName("beerId").description("UUID of desired beer to get.")
                ), PayloadDocumentation.responseFields(
                        PayloadDocumentation.fieldWithPath("id").description("Id of the beer")
                )));
    }

    @Test
    void saveNewBeer() throws Exception{
        BeerDTO beerDTO = BeerDTO.builder().build();
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/beer")
                .content(objectMapper.writeValueAsString(beerDTO)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

    @Test
    void updateBeerById() throws Exception{
        BeerDTO beerDTO = BeerDTO.builder().build();
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/beer/" + UUID.randomUUID().toString())
                .content(objectMapper.writeValueAsString(beerDTO)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }
}