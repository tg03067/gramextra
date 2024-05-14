package com.green.gramextra.feed.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class FeedInsReq {
    @JsonIgnore
    private long feedId;

    private long userId;
    private String contents;
    private String location;
}
