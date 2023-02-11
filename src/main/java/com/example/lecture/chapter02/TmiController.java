package com.example.lecture.chapter02;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Locale;

@RestController
@Slf4j
@SessionAttributes("name")
@RequestMapping("/lec2/tmi")
public class TmiController {


    // localhost:8080/lec2/tmi/v1
    @GetMapping("/v1")
    public String tmi(HttpServletRequest request,
                      HttpServletResponse response,
                      HttpMethod method,
                      Locale locale,
                      @RequestHeader MultiValueMap<String, String> headerMap,
                      @CookieValue(value = "tmiCookie",required = false) String cookie,
                      Model model) {

        log.info("\n request = {}", request);
        log.info("\n response = {}" , response);
        log.info("\n httpMethod = {}" , method);
        log.info("\n locale = {}",locale);

        log.info("\n headerMap = {}" ,headerMap);
        log.info("\n cookie = {}" ,cookie);
        model.addAttribute("name","saechim");

        return "hello "+ request.getSession().getAttribute("name");

    }
}
