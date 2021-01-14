package com.example.thirdpart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jayying
 * @since 2021/1/14
 */
@Controller
@RequestMapping("index")
public class IndexController {
    @GetMapping
    public String index() {
        return "index";
    }
}
