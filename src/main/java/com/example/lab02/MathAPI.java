package com.example.lab02;

import org.springframework.web.bind.annotation.*;

@RestController
public class MathAPI {
    @RequestMapping(value = "/plus/{num1}/{num2}", method = RequestMethod.GET)
    public String myPlus(@PathVariable("num1") double n1, @PathVariable("num2") double n2) {
        return "" + (n1 + n2);
    }

    @RequestMapping(value = "/minus/{num1}/{num2}", method = RequestMethod.GET)
    public String myMinus(@PathVariable("num1") double n1, @PathVariable("num2") double n2) {
        return "" + (n1 - n2);
    }

    @RequestMapping(value = "/multi/{num1}/{num2}", method = RequestMethod.GET)
    public String myMultiply(@PathVariable("num1") double n1, @PathVariable("num2") double n2) {
        return "" + (n1 * n2);
    }

    @RequestMapping(value = "/divide/{num1}/{num2}", method = RequestMethod.GET)
    public String myDivide(@PathVariable("num1") double n1, @PathVariable("num2") double n2) {
        return "" + (n1 / n2);
    }
    @RequestMapping(value = "/mod/{num1}/{num2}", method = RequestMethod.GET)
    public String myMod(@PathVariable("num1") double n1, @PathVariable("num2") double n2) {
        return "" + (n1 % n2);
    }
    @RequestMapping(value = "/max", method = RequestMethod.POST)
    public String myMax(@RequestParam double n1, @RequestParam double n2) {
        if(n1 > n2){ return "" + n1;}
        else { return "" + n2;}
    }
}