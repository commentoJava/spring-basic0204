package com.example.lecture.chapter02;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
@Slf4j
public class HelloServlet extends HttpServlet {

    // localhost:8080/hello?name=saechim
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("\n helloServlet");
        log.info("\n name {}",req.getParameter("name"));
        log.info("\n request = {}", req);
        log.info("\n res  = {}",resp);
    }
}
