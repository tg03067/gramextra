package com.green.gramextra.feed;

import com.green.gramextra.common.CustomFileUtils;
import com.green.gramextra.common.GlobalConst;
import com.green.gramextra.feed.model.*;
import com.green.gramextra.feedcomment.model.FeedCommentSelRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class FeedService {
    private final FeedMapper mapper;
    private final CustomFileUtils customFileUtils;

    public FeedInsRes insFeed(List<MultipartFile> pic, FeedInsReq p){
        int result = mapper.insFeed(p);
        FeedPicInsDto picDto = FeedPicInsDto.builder().feedId(p.getFeedId()).build();
        try{
            String path = String.format("feed/%d", p.getFeedId());
            customFileUtils.makeFolders(path);
            for(MultipartFile res : pic) {
                String saveFileName = customFileUtils.makeRandomFileName(res);
                picDto.getFileNames().add(saveFileName);
                String target = String.format("%s/%s", path, saveFileName);
                customFileUtils.transferTo(res, target);
            }
            int affectedRows = mapper.insFeedPics(picDto);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Feed 등록 오류");
        }
        return FeedInsRes.builder().
                feedId(p.getFeedId()).
                pics(picDto.getFileNames()).
                build();
    }
    public List<FeedSelRes> selFeed(FeedSelReq p){
        List<FeedSelRes> list = mapper.selFeed(p);
        if(list == null){
            return Collections.emptyList();
        }
        for(FeedSelRes res : list){
            List<String> pics = mapper.selFeedPicsByFeedId(res.getFeedId());
            res.setPics(pics);

            List<FeedCommentSelRes> comments = mapper.selFeedCommentTopBy4ByFeedId(res.getFeedId());
            boolean hasMoreComment = comments.size() == GlobalConst.COMMENT_SIZE_PER_FEED;
            res.setIsMoreComment( hasMoreComment ? 1 : 0 );
            if(hasMoreComment){
                comments.remove(comments.size() - 1 );
            }
            res.setComments(comments);
        }
        return list;
    }
}
