package com.green.gramextra.feedcomment;

import com.green.gramextra.feedcomment.model.FeedCommentDeleteReq;
import com.green.gramextra.feedcomment.model.FeedCommentInsReq;
import com.green.gramextra.feedcomment.model.FeedCommentSelRes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedCommentMapper {
    int insFeedComment(FeedCommentInsReq p);
    int delFeedComment(FeedCommentDeleteReq p);
    List<FeedCommentSelRes> selFeedComment(long feedId);
}
