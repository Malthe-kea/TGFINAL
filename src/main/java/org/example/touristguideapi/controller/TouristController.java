package org.example.touristguideapi.controller;

import jakarta.websocket.server.PathParam;
import org.example.touristguideapi.service.TouristService;
import org.example.touristguideapi.model.TouristAttraction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attractions")
public class TouristController {
    private final TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    @GetMapping("")
    public ResponseEntity<List<TouristAttraction>> getTouristAttractions() {
        List<TouristAttraction> listOfTouristAttractions = touristService.getAllAttractions();
        return new ResponseEntity<>(listOfTouristAttractions, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<TouristAttraction> getTouristAttractionByName(@PathVariable String name) {
        return new ResponseEntity<>(touristService.getTouristAttractionByName(name), HttpStatus.OK);
    }
//hej IGEN
    @PostMapping("/add")
    public ResponseEntity<TouristAttraction> addTouristAttraction(@RequestBody TouristAttraction touristAttraction){
        return new ResponseEntity<>(touristService.addTouristAttraction(touristAttraction),HttpStatus.CREATED);
    }

    @PostMapping("delete/{name}")
    public ResponseEntity<TouristAttraction> deleteTouristAttractionByName(@PathVariable String name) {
        TouristAttraction touristAttraction = touristService.getTouristAttractionByName(name);
        touristService.deleteTouristAttraction(touristAttraction);
        return new ResponseEntity<>( touristAttraction, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<TouristAttraction> updateTouristAttraction(@PathVariable int id, @RequestBody TouristAttraction touristAttraction){
       TouristAttraction updatedTouristAttraction = touristService.updateTouristAttraction(touristAttraction, id);
       if(updatedTouristAttraction == null){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
        return new ResponseEntity<>( updatedTouristAttraction, HttpStatus.OK);
    }

}
