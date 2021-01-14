package com.example.authserver.controller;

import com.example.authserver.mock.AuthInfoDB;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jayying
 * @since 2021/1/13
 */
@Controller
@RequestMapping("index")
public class IndexController {
    @RequestMapping
    public String index(Model model) {
        model.addAttribute("allAuths", AuthInfoDB.getAuthInfos());

        return "index";
    }

}
