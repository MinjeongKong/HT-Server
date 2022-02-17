package com.healthtrainer.htserver.web.controller.login;

import com.healthtrainer.htserver.service.login.UserService;
import com.healthtrainer.htserver.web.dto.ResponseDto;
import com.healthtrainer.htserver.web.dto.login.UserCreateRequestDto;
import com.healthtrainer.htserver.web.dto.login.UserUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

    //유저 프로필 정보 설정 및 수정
//    @PostMapping("/users/profile/me")
//    public ResponseDto createUser(ServletRequest request, @RequestBody UserCreateRequestDto requestDto) {
//        return userService.createUser(request, requestDto);
//    }

    @PostMapping("/user/profile/me")
    public ResponseDto updateUser(ServletRequest request, @ModelAttribute UserUpdateRequestDto requestDto, @RequestParam(value = "file", required = false) MultipartFile file) throws Exception {
        return userService.updateUser(request, requestDto, file);
    }

    //타 유저 프로필 정보 요청
    @GetMapping("/users/{userId}/profile")
    public ResponseDto findUser(@PathVariable Long userId) {
        return userService.findUser(userId);
    }


    //내 프로필 정보 요청
    @GetMapping("/users/profile/me")
    public ResponseDto findMe(ServletRequest request) {
        return userService.findMe(request);
    }
}