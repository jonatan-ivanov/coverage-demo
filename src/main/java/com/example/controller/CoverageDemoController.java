package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author Jonatan Ivanov
 */
@Controller
public class CoverageDemoController {

    @RequestMapping(path = "/echo/{message}", method = GET)
    @ResponseBody public String echo(@PathVariable String message) {
        return message;
    }

    @RequestMapping(path = "/hello", method = GET)
    @ResponseBody public String hello() {
        return "Oh, Hai!";
    }
}
