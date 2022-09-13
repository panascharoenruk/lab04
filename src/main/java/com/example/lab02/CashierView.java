package com.example.lab02;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextFieldVariant;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.textfield.TextField;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.awt.*;



@Route(value = "index")
public class CashierView extends VerticalLayout{
    private TextField munnie, n1000, n500, n100, n20, n10, n5, n1;
    private Button btnChange;
    public CashierView(){
        munnie = new TextField("เงินทอน");
        munnie.setPrefixComponent(new Span("$: "));
        btnChange = new Button("คำนวณเงินทอน");
        n1000 = new TextField();
        n1000.setPrefixComponent(new Span("$1000: "));
        n500 = new TextField();
        n500.setPrefixComponent(new Span("$500: "));
        n100 = new TextField();
        n100.setPrefixComponent(new Span("$100: "));
        n20 = new TextField();
        n20.setPrefixComponent(new Span("$20: "));
        n10 = new TextField();
        n10.setPrefixComponent(new Span("10: "));
        n5 = new TextField();
        n5.setPrefixComponent(new Span("$5: "));
        n1 = new TextField();
        n1.setPrefixComponent(new Span("$1: "));
        add(munnie, btnChange, n1000, n500, n100, n20, n10, n5, n1);

        btnChange.addClickListener(event ->{
            int mun = Integer.parseInt(munnie.getValue());
            Change out = WebClient.create() // สร้างช
                    .get() // กําหนดรูปแบบการสื3อสาร
                    .uri("http://localhost:8080/getChange/"+mun)
                    .retrieve() // ให้รอรับข้อมูลกลับมา
                    .bodyToMono(Change.class) // กําหนด Spec ของ Response
                    .block(); // Blocking thread
            n1000.setValue("" + out.getB1000());
            n500.setValue("" + out.getB500());
            n100.setValue("" + out.getB100());
            n20.setValue("" + out.getB20());
            n10.setValue("" + out.getB10());
            n5.setValue("" + out.getB5());
            n1.setValue("" + out.getB1());
        });



    }
}
