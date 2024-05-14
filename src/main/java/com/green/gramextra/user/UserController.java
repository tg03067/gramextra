package com.green.gramextra.user;

import com.green.gramextra.common.model.ResultDto;
import com.green.gramextra.user.model.SignInReq;
import com.green.gramextra.user.model.SignInRes;
import com.green.gramextra.user.model.UserSignUpReq;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/user")
@Slf4j
@Tag(name = "유저관련 인터페이스", description = "회원가입, 로그인 가능")
public class UserController {
    private final UserService service;

    @PostMapping("sign-up")
    @Operation(summary = "회원가입", description = "프로필 사진은 필수가 아닙니다.")
    public ResultDto<Integer> insUser(@RequestPart(required = false) MultipartFile pic,
                                      @RequestPart UserSignUpReq p){
        int result = service.insUser(pic, p);
        return ResultDto.<Integer>builder().
                httpStatus(HttpStatus.OK).
                resultMsg("회원가입 성공").
                resultData(result).
                build();
    }
    @PostMapping("sign-in")
    @Operation(summary = "로그인")
    public ResultDto<SignInRes> selUserById(@RequestBody SignInReq p){
        SignInRes result = service.selUserById(p);
        return ResultDto.<SignInRes>builder().
                httpStatus(HttpStatus.OK).
                resultMsg("인증 성공").
                resultData(result).
                build();
    }
}
