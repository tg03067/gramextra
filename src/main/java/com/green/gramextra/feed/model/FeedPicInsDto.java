package com.green.gramextra.feed.model;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class FeedPicInsDto {
    private long feedId;
    @Builder.Default
    private List<String> fileNames = new ArrayList<>();
}
