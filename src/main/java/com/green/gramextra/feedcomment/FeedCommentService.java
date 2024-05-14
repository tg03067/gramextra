package com.green.gramextra.feedcomment;

import com.green.gramextra.feedcomment.model.FeedCommentDeleteReq;
import com.green.gramextra.feedcomment.model.FeedCommentInsReq;
import com.green.gramextra.feedcomment.model.FeedCommentSelRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class FeedCommentService {
    private final FeedCommentMapper mapper;
    public long insFeedComment(FeedCommentInsReq p){
        int affectedRows = mapper.insFeedComment(p);
        return p.getFeedCommentId();
    }
    public int delFeedComment(FeedCommentDeleteReq p){
        return mapper.delFeedComment(p);
    }
    public List<FeedCommentSelRes> selFeedComment(long feedId){
        return mapper.selFeedComment(feedId);
    }
}
