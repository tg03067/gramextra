package com.green.gramextra.feedfavorite;

import com.green.gramextra.common.CustomFileUtils;
import com.green.gramextra.feedfavorite.model.FeedFavoriteToggleReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class FeedFavoriteService {
    private final FeedFavoriteMapper mapper;
    private final CustomFileUtils customFileUtils;

    public int insFeedFavorite(FeedFavoriteToggleReq p){
        int result = mapper.delFeedFavorite(p);
        if(result == 1){
            return 0;
        }
        return mapper.insFeedFavorite(p);
    }
}
