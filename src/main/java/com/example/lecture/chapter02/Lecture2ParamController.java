package com.example.lecture.chapter02;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController // @Controller + @ResponseBody
@RequestMapping("/lec2/param")
public class Lecture2ParamController {


    // localhost:8080/lec2/param/v1?name=saechim&message=hello
    @GetMapping("/v1")
    public String requestParamV1(HttpServletRequest request) {
        return request.getParameter("name") + "__" + request.getParameter("message");
    }


    // localhost:8080/lec2/param/v2?name=saechim&message=hello
    @GetMapping("/v2")
    public String requestParamV2(@RequestParam("name") String name, @RequestParam("message") String message){
        return name + "__" + message;
    }


    // localhost:8080/lec2/param/v3?name=saechim&message=hello
    @GetMapping("/v3")
    public String requestParamV3(@RequestParam String name, @RequestParam String message){
        return name + "__" + message;
    }

    @GetMapping("/v4")
    public String requestParamV3(@RequestParam Map<String, String> map){
        return map.get("name") + "__" + map.get("message");
    }


    // localhost:8080/lec2/param/v5?name=saechim&message=hello&message=world
    @GetMapping("/v5")
    public String requestParamV3(@RequestParam MultiValueMap<String, String> map){
        // key : string ,value [string, string...]

        return map.get("name") + "__" + map.get("message");
    }


    // localhost:8080/lec2/param/company/{companyId}
    @GetMapping("/company/{companyId}")
    public String getCompanyName(@PathVariable("companyId") Long companyId){
        return companyData.getOrDefault(companyId, "COMMENTO");
    }

    private Map<Long,String> companyData;

    @PostConstruct
    public void init(){
        companyData = Map.of(1L, "samsung", 2L, "SK");
    }




}
