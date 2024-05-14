package com.green.gramextra.feed;

import com.green.gramextra.feed.model.FeedInsReq;
import com.green.gramextra.feed.model.FeedPicInsDto;
import com.green.gramextra.feed.model.FeedSelReq;
import com.green.gramextra.feed.model.FeedSelRes;
import com.green.gramextra.feedcomment.model.FeedCommentSelRes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedMapper {
    int insFeed(FeedInsReq p);
    int insFeedPics(FeedPicInsDto p);
    List<FeedSelRes> selFeed(FeedSelReq p);
    List<String> selFeedPicsByFeedId(long feedId);
    List<FeedCommentSelRes> selFeedCommentTopBy4ByFeedId(long feedId);
}
