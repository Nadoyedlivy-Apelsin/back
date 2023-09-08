package com.geverse.controller.core;

import com.geverse.entity.GeneratedSequence;
import com.geverse.service.GeneratedSequenceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(CardsController.BASE_URL)
public class CardsController {
    static final String BASE_URL = "geverse.ru/";
    private final GeneratedSequenceService service;

    public CardsController(GeneratedSequenceService service) {
        this.service = service;
    }
    @GetMapping("/get_generated")
    public GeneratedSequence transferGeneratedProtein() {
        int maxId = Math.toIntExact(service.getMaxIdFromGenerated());
        for (int id = 0; id < maxId; id++) {
            return service.findById(Long.valueOf(id));
        }
        return null;
    }

}
