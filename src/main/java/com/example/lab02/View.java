package com.example.lab02;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.textfield.TextField;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.awt.*;



@Route(value = "index1")
public class View extends VerticalLayout{
    private TextField n1, n2, n3;
    private Button btnPlus, btnMinus, btnMulti, btnDivide, btnMod, btnMax;
    public View(){
        HorizontalLayout btnLayout = new HorizontalLayout();


        n1 = new TextField("Number 1");
        n2 = new TextField("Number 2");
        n3 = new TextField("Answer");
        btnPlus = new Button("+");
        btnMinus = new Button("-");
        btnMulti = new Button("*");
        btnDivide = new Button("/");
        btnMod = new Button("Mod");
        btnMax = new Button("Max");
        btnLayout.add(btnPlus, btnMinus, btnMulti, btnDivide, btnMod, btnMax);
        add(n1, n2, btnLayout, n3);
        btnPlus.addClickListener(event ->{
            double num1 = Double.parseDouble(n1.getValue());
            double num2 = Double.parseDouble(n2.getValue());
            String out = WebClient.create() // สร้างช
                    .get() // กําหนดรูปแบบการสื3อสาร
                    .uri("http://localhost:8080/plus/"+num1+"/"+num2)
                    .retrieve() // ให้รอรับข้อมูลกลับมา
                    .bodyToMono(String.class) // กําหนด Spec ของ Response
                    .block(); // Blocking thread
            n3.setValue(out);
        });
        btnMinus.addClickListener(event ->{
            double num1 = Double.parseDouble(n1.getValue());
            double num2 = Double.parseDouble(n2.getValue());
            String out = WebClient.create() // สร้างช
                    .get() // กําหนดรูปแบบการสื3อสาร
                    .uri("http://localhost:8080/minus/"+num1+"/"+num2)
                    .retrieve() // ให้รอรับข้อมูลกลับมา
                    .bodyToMono(String.class) // กําหนด Spec ของ Response
                    .block(); // Blocking thread
            n3.setValue(out);
        });
        btnMulti.addClickListener(event ->{
            double num1 = Double.parseDouble(n1.getValue());
            double num2 = Double.parseDouble(n2.getValue());
            String out = WebClient.create() // สร้างช
                    .get() // กําหนดรูปแบบการสื3อสาร
                    .uri("http://localhost:8080/multi/"+num1+"/"+num2)
                    .retrieve() // ให้รอรับข้อมูลกลับมา
                    .bodyToMono(String.class) // กําหนด Spec ของ Response
                    .block(); // Blocking thread
            n3.setValue(out);
        });
        btnDivide.addClickListener(event ->{
            double num1 = Double.parseDouble(n1.getValue());
            double num2 = Double.parseDouble(n2.getValue());
            String out = WebClient.create() // สร้างช
                    .get() // กําหนดรูปแบบการสื3อสาร
                    .uri("http://localhost:8080/divide/"+num1+"/"+num2)
                    .retrieve() // ให้รอรับข้อมูลกลับมา
                    .bodyToMono(String.class) // กําหนด Spec ของ Response
                    .block(); // Blocking thread
            n3.setValue(out);
        });
        btnMod.addClickListener(event ->{
            double num1 = Double.parseDouble(n1.getValue());
            double num2 = Double.parseDouble(n2.getValue());
            String out = WebClient.create() // สร้างช
                    .get() // กําหนดรูปแบบการสื3อสาร
                    .uri("http://localhost:8080/mod/"+num1+"/"+num2)
                    .retrieve() // ให้รอรับข้อมูลกลับมา
                    .bodyToMono(String.class) // กําหนด Spec ของ Response
                    .block(); // Blocking thread
            n3.setValue(out);
        });
        btnMax.addClickListener(event ->{
            MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
            formData.add("n1", n1.getValue()); // key คือ n1, value คือ n1.getValue())
            formData.add("n2", n2.getValue());
            String out = WebClient.create()
                    .post()
                    .uri("http://localhost:8080/max")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .body(BodyInserters.fromFormData(formData))
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            n3.setValue(out);
        });



    }
}
