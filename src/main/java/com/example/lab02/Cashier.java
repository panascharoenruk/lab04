package com.example.lab02;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Cashier {
    @RequestMapping(value = "/getChange/{num1}", method = RequestMethod.GET)
    public Change getChange(@PathVariable("num1") int n1) {
        Change res = new Change();
        res.setB1000(n1 / 1000);
        n1 = n1 % 1000;
        res.setB500(n1 / 500);
        n1 = n1 % 500;
        res.setB100(n1 / 100);
        n1 = n1 % 100;
        res.setB20(n1 / 20);
        n1 = n1 % 20;
        res.setB10(n1 / 10);
        n1 = n1 % 10;
        res.setB5(n1 / 5);
        n1 = n1 % 5;
        res.setB1(n1 / 1);
        return res;
    }
}
