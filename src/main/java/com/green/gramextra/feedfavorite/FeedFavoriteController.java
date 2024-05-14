package com.green.gramextra.feedfavorite;

import com.green.gramextra.common.model.ResultDto;
import com.green.gramextra.feedfavorite.model.FeedFavoriteToggleReq;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/feed/favorite")
@Tag(name = "좋아요 표시", description = "좋아요를 하기위한 Swagger")
public class FeedFavoriteController {
    private final FeedFavoriteService service;

    @GetMapping
    @Operation(summary = "좋아요", description = "Toggle 처리")
    public ResultDto<Integer> toggleFavorite(@ModelAttribute FeedFavoriteToggleReq p){
        int result = service.insFeedFavorite(p);
        return ResultDto.<Integer>builder().
                httpStatus(HttpStatus.OK).
                resultMsg(result == 1 ? "좋아요 처리" : "좋아요 취소").
                resultData(result).
                build();
    }
}
