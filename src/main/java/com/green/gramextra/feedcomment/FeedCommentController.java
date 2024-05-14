package com.green.gramextra.feedcomment;

import com.green.gramextra.common.model.ResultDto;
import com.green.gramextra.feedcomment.model.FeedCommentDeleteReq;
import com.green.gramextra.feedcomment.model.FeedCommentInsReq;
import com.green.gramextra.feedcomment.model.FeedCommentSelRes;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/feed/comment")
@RestController
@Tag(name = "Feed 댓글", description = "댓글관련")
public class FeedCommentController {
    private final FeedCommentService service;

    @PostMapping
    @Operation(summary = "댓글쓰기")
    public ResultDto<Long> insFeedComment(@RequestBody FeedCommentInsReq p){
        long feedCommentId = service.insFeedComment(p);
        return ResultDto.<Long>builder().
                httpStatus(HttpStatus.OK).
                resultMsg(HttpStatus.OK.toString()).
                resultData(feedCommentId).
                build();
    }
    @DeleteMapping
    @Operation(summary = "댓글지우기")
    public ResultDto<Integer> deleteFeedComment(@ParameterObject @ModelAttribute FeedCommentDeleteReq p){
        int result = service.delFeedComment(p) ; //0은 삭제 실패, 1은 삭제 성공

        return ResultDto.<Integer>builder().
                httpStatus(HttpStatus.OK).
                resultMsg(result == 0 ? "댓글 삭제를 할 수 없습니다." : "댓글을 삭제하였습니다.").
                resultData(result).
                build();
    }
    @GetMapping
    @Operation(summary = "댓글 가져오기")
    public ResultDto<List<FeedCommentSelRes>> getFeedComment(@RequestParam(name = "feed_id") Long feedId) {
        List<FeedCommentSelRes> list = service.selFeedComment(feedId);

        return ResultDto.<List<FeedCommentSelRes>>builder().
                httpStatus(HttpStatus.OK).
                resultMsg(String.format("rows: %,d", list.size())).
                resultData(list).
                build();
    }
}
