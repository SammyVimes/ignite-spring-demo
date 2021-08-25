package com.gridgain.training.spring.controller;

import java.util.List;
import com.gridgain.training.spring.model.CityProjection;
import com.gridgain.training.spring.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorldDatabaseController {

    @Autowired
    private CityRepository cityRepository;

    @GetMapping("/api/mostPopulated")
    public List<CityProjection> getMostPopulatedCities(@RequestParam(value = "limit", required = false) Integer limit) {
        return cityRepository.findTopXMostPopulatedCities(limit);
    }

}
