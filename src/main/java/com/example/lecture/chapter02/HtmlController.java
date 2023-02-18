package com.example.lecture.chapter02;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HtmlController {


    //localhost:8080/html
    @GetMapping("/html")
    public String helloHtml(Model model) {
        model.addAttribute("name", "saechim");
        return "Lecture2";
    }
}
