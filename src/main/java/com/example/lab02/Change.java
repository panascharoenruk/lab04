package com.example.lab02;


import com.vaadin.flow.router.Route;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.io.Serializable;

@Component
public class Change implements Serializable {
    private int b1000, b500, b100, b20, b10, b5, b1;
    public Change() {
        this.b1000 = 0;
        this.b500 = 0;
        this.b100 = 0;
        this.b20 = 0;
        this.b10 = 0;
        this.b5 = 0;
        this.b1 = 0;
    }
    public void setB1000(int newB1000){
       this.b1000 = newB1000;
    }
    public int getB1000(){ return  b1000;}

    public void setB500(int newB500){
        this.b500 = newB500;
    }
    public int getB500(){ return  b500;}

    public void setB100(int newB100){
        this.b100 = newB100;
    }
    public int getB100(){ return  b100;}

    public void setB20(int newB20){
        this.b20 = newB20;
    }
    public int getB20(){ return  b20;}

    public void setB10(int newB10){
        this.b10 = newB10;
    }
    public int getB10(){ return  b10;}

    public void setB5(int newB5){
        this.b5 = newB5;
    }
    public int getB5(){ return  b5;}

    public void setB1(int newB1){
        this.b1 = newB1;
    }
    public int getB1(){ return  b1;}
}
