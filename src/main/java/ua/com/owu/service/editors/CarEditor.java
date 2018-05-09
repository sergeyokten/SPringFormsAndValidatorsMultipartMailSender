package ua.com.owu.service.editors;

import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@Component
public class CarEditor extends PropertyEditorSupport {


    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        System.out.println("asd");
        System.out.println(text);
    }
}
