package com.example.lecture.chapter02;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lec2/session")
public class SessionController {

    // localhost:8080/lec2/session/login
    @GetMapping("/login")
    public String login(HttpSession session){

        if(session.getAttribute("id") == null){
            session.setAttribute("id","saechim");
            throw new RuntimeException("잘못된 접근입니다");
        }

        return "안녕하세요 " + session.getAttribute("id") +"님";
    }
}
