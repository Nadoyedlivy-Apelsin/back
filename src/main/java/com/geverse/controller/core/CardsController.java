package com.geverse.controller.core;

import com.geverse.service.GeneratedSequenceService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(CardsController.BASE_URL)
public class CardsController {
    static final String BASE_URL = "geverse.ru/";
//    private final GeneratedSequenceService service;
//
//    public CardsController(GeneratedSequenceService service) {
//        this.service = service;
//    }
//    @GetMapping("/get")
//    public void transferGeneratedProtein() {
//        service.findById();
//
//    }

}
