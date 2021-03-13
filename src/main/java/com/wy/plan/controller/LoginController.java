package com.wy.plan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author WangYao
 * @date 2021/3/2
 * @function
 */
@Controller
public class LoginController {
    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session){
        if("root".equals(username) && "123456".equals(password)){
            session.setAttribute("loginUser", username);
            return "commons/thingsCommon";
        }
        model.addAttribute("rightName", "false");
        return "index";
    }
}
