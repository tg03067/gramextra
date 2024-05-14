package com.green.gramextra.feed.model;


import com.green.gramextra.common.GlobalConst;
import com.green.gramextra.common.model.Paging;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.BindParam;

@Getter
@Setter
public class FeedSelReq extends Paging {
    @Schema(name = "signed_user_id")
    private Long signedUserId;

    public FeedSelReq(Integer page, Integer size, @BindParam("signed_user_id") Long signedUserId){
        super(page, size == null || size == 0? GlobalConst.FEED_PAGING_SIZE : size );
        this.signedUserId = signedUserId;
    }
}
