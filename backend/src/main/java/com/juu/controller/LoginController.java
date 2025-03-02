package com.juu.controller;

import com.juu.common.JsonResult;
import com.juu.param.LoginParam;
import com.juu.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @PostMapping("/login")
    public JsonResult login(@RequestBody LoginParam loginParam){
        return JsonResult.success(loginService.login(loginParam));
    }

}
