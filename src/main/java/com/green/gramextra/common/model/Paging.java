package com.green.gramextra.common.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class Paging {
    private final Integer page;
    private final Integer size;

    public Paging(Integer page, Integer size){
        this.page = page;
        this.size = size == 0 ? 10 : size;
        this.startIdx = ( this.page - 1 ) < 0 ? 0 : ( this.page - 1 ) * this.size ;
    }
    @JsonIgnore
    private final Integer startIdx;
}
