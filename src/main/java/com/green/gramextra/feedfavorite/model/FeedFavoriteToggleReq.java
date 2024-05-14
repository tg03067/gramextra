package com.green.gramextra.feedfavorite.model;

import lombok.Data;

@Data
public class FeedFavoriteToggleReq {
    private long feedId;
    private long userId;
}
