package com.afrikatek.mscbeerservice.web.model;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * project msc-beer-service
 * created by murukai
 * created on 2023/02/13 at 03:58:02
 */
public class BeerPageList extends PageImpl<BeerDTO> {
    public BeerPageList(List<BeerDTO> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public BeerPageList(List<BeerDTO> content) {
        super(content);
    }
}
