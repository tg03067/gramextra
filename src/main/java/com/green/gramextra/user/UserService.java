package com.green.gramextra.user;

import com.green.gramextra.common.CustomFileUtils;
import com.green.gramextra.user.model.SignInReq;
import com.green.gramextra.user.model.SignInRes;
import com.green.gramextra.user.model.User;
import com.green.gramextra.user.model.UserSignUpReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;
    private final CustomFileUtils customFileUtils;

    @Transactional
    public int insUser(MultipartFile pic, UserSignUpReq p){
        String saveFileName = customFileUtils.makeRandomFileName(pic);
        p.setPic(saveFileName);
        String hashPassword = BCrypt.hashpw(p.getUpw(), BCrypt.gensalt());
        p.setUpw(hashPassword);

        int result = mapper.insUser(p);
        if( pic == null ){
            return result;
        }
        try {
            String path = String.format("user/%d", p.getUserId());
            customFileUtils.makeFolders(path);
            String target = String.format("%s/%s", path, saveFileName);
            customFileUtils.transferTo(pic, target);
        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("파일오류");
        }

        return result;
    }

    public SignInRes selUserById(SignInReq p){
        User user = mapper.selUserById(p.getUid());
        if(Objects.isNull(user)){
            throw new RuntimeException("아이디를 확인해 주세요.");
        } else if (!BCrypt.checkpw(p.getUpw(), user.getUpw())) {
            throw new RuntimeException("비밀번호를 확인해 주세요.");
        }

        return SignInRes.builder().
                userId(user.getUserId()).
                nm(user.getNm()).
                pic(user.getPic()).
                build();
    }
}
