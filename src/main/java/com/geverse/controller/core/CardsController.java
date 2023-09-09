package com.geverse.controller.core;

import com.geverse.entity.GeneratedSequence;
import com.geverse.service.GeneratedSequenceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(CardsController.BASE_URL)
public class CardsController {
    static final String BASE_URL = "api.geverse.ru/";
    private final GeneratedSequenceService service;

    public CardsController(GeneratedSequenceService service) {
        this.service = service;
    }
    @RequestMapping("/get_generated")
    public List<GeneratedSequence> transferGeneratedProtein() {
        int maxId = Math.toIntExact(service.getMaxIdFromGenerated());
        List<GeneratedSequence> generatedSequenceList = new ArrayList<>();
        for (int id = 0; id < maxId; id++) {
            generatedSequenceList.add(service.findById(Long.valueOf(id)));
        }
        return generatedSequenceList;
    }

}
