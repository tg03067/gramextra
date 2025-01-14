package com.green.gramextra.user.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SignInReq {
    @Schema(example = "mic", description = "유저 아이디", requiredMode = Schema.RequiredMode.REQUIRED)
    private String uid;
    @Schema(example = "1212", description = "유저 비밀번호", requiredMode = Schema.RequiredMode.REQUIRED)
    private String upw;
}
