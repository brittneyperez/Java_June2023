package com.javastack.counter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/my_server")
public class CounterController {

    @RequestMapping("")
    public String index(HttpSession session, Model model) {
        Integer count = (Integer) session.getAttribute("count");
        if (count == null) {
            count = 0;
        }
        model.addAttribute("count", count);
        return "welcome.jsp";
    }

    @RequestMapping("/counter")
    public String displayCounter(HttpSession session) {

        Integer count = (Integer) session.getAttribute("count");
        if (count == null) {
            count = 0; // Reset the counter to 0
        }
        session.setAttribute("count", count + 1);
        return "counter.jsp";
    }

    @RequestMapping("/counter2")
    public String displayCounter2(HttpSession session) {

        Integer count = (Integer) session.getAttribute("count");
        if (count == null) {
            count = 0; // Reset the counter to 0
        }
        session.setAttribute("count", count + 2);
        return "counter.jsp";
    }

    @RequestMapping("/reset")
    public String resetCounter(HttpSession session) {
        session.removeAttribute("count");
        return "welcome.jsp";
    }
}
