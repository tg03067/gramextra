package com.green.gramextra.feedfavorite;

import com.green.gramextra.feedfavorite.model.FeedFavoriteToggleReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FeedFavoriteMapper {
    int insFeedFavorite(FeedFavoriteToggleReq p);
    int delFeedFavorite(FeedFavoriteToggleReq p);
}
