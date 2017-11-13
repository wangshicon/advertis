package com.lord.advertis.controller;

import com.lord.advertis.common.ResultAjax;
import com.lord.advertis.domain.Users;
import com.lord.advertis.interceptor.WebSecurityConfig;
import com.lord.advertis.service.UsersService;
import com.lord.advertis.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 *
 * 用户管理
 * Created by on 2017/10/31.
 */

@Controller
@RequestMapping(value = "/manager/user")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/login")
    public String login() {
        return "manager/login";
    }

    @PostMapping("/login")
    @ResponseBody
    public ResultAjax<Users> loginPost(Users users, BindingResult bindingResult, HttpSession session) {
        if(bindingResult.hasErrors()){
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        Users user = usersService.findByLoginName(users.getLoginname());

        if (!users.getPassword().equals(user.getPassword())) {
            return ResultUtil.error(2, "账户密码不匹配~");
        }

        // 设置session
        session.setAttribute(WebSecurityConfig.SESSION_KEY, user.getLoginname());

        return ResultUtil.success();
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 移除session
        session.removeAttribute(WebSecurityConfig.SESSION_KEY);
        return "redirect:/manager/user/login";
    }

}
