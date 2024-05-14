package com.green.gramextra.feed.model;

import com.green.gramextra.feedcomment.model.FeedCommentSelRes;
import lombok.Data;

import java.util.List;

@Data
public class FeedSelRes {
    private long feedId;
    private long writerId;
    private String writerNm;
    private String writerPic;
    private String contents;
    private String location;
    private String createdAt;
    private int isFav;

    private List<String> pics;
    private List<FeedCommentSelRes> comments;
    private int isMoreComment;
}
