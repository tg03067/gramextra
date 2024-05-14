package com.green.gramextra.feedcomment.model;

import lombok.Data;

@Data
public class FeedCommentSelRes {
    private long feedCommentId;
    private String comment;
    private String createdAt;
    private long writerId;
    private String writerNm;
    private String writerPic;
}
