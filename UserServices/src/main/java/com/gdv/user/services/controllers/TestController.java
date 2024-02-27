package com.gdv.user.services.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {
    @GetMapping("/testAll")
    public List<String> createHugeData() throws InterruptedException {

        List<String> list = new ArrayList<>();

        System.out.println("Thread name : "+Thread.currentThread().getName());

        for (int i = 1; i <= 10; i++) {
            String str = "Hi, I am name "+i;
            Thread.sleep(1000);
            list.add(str);
        }
        return list;
    }

    @GetMapping("/testSingle")
    public String getSingle() {
        return "Hello I am only one name...";
    }
}
