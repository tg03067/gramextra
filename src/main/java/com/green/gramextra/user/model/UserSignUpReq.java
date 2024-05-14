package com.green.gramextra.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UserSignUpReq {
    @Schema(example = "mic", description = "유저 아이디", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String uid;
    @Schema(example = "1212", description = "유저 비밀번호", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String upw;
    @Schema(example = "홍길동", description = "유저 이름", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String nm;

    @JsonIgnore
    private String pic;
    @JsonIgnore
    private long userId;
}
