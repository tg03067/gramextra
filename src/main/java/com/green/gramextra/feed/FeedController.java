package com.green.gramextra.feed;

import com.green.gramextra.common.model.ResultDto;
import com.green.gramextra.feed.model.FeedInsReq;
import com.green.gramextra.feed.model.FeedInsRes;
import com.green.gramextra.feed.model.*;
import com.green.gramextra.feed.model.FeedSelRes;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("api/feed")
@Tag(name = "유저 컨트롤러", description = "유저 CRUD, sign-up, sign-out")
public class FeedController {
    private final FeedService service;

    @PostMapping
    @Operation(summary = "Feed 등록")
    public ResultDto<FeedInsRes> insFeed(@RequestPart List<MultipartFile> pics,
                                         @RequestPart FeedInsReq p){
        FeedInsRes res = service.insFeed(pics, p);

        return ResultDto.<FeedInsRes>builder().
                httpStatus(HttpStatus.OK).
                resultMsg("Feed 등록").
                resultData(res).
                build();
    }
    @GetMapping
    @Operation(summary = "Feed 리스트", description = "loginUserId는 로그인한 사용자의 PK")
    public ResultDto<List<FeedSelRes>> selFeed(@ParameterObject @ModelAttribute FeedSelReq p){
        List<FeedSelRes> list = service.selFeed(p);
        return ResultDto.<List<FeedSelRes>>builder().
                httpStatus(HttpStatus.OK).
                resultMsg(HttpStatus.OK.toString()).
                resultData(list).
                build();
    }
}
