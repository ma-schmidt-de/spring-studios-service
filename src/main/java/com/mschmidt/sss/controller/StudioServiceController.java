package com.mschmidt.sss.controller;

import com.mschmidt.sss.entity.Studio;
import com.mschmidt.sss.repository.StudioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
public class StudioServiceController {

    private final StudioRepository studioRepo;

    public StudioServiceController(StudioRepository studioRepository) {
        this.studioRepo = studioRepository;
    }

    @GetMapping(value = "/studio", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Studio> getRides() {
        return studioRepo.findAll();
    }

    @GetMapping(value = "/studio/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Studio getRide(@PathVariable long id){
        return studioRepo.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Invalid ride id %s", id)));
    }

    @PostMapping(value = "/studio", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Studio createRide(@Valid @RequestBody Studio themeParkRide) {
        return studioRepo.save(themeParkRide);
    }
}
