package org.example.touristguideapi.service;

import org.example.touristguideapi.model.TouristAttraction;
import org.springframework.stereotype.Service;
import org.example.touristguideapi.repository.TouristRepository;

import java.util.List;

@Service
public class TouristService {

    public final TouristRepository touristRepository;

    public TouristService(TouristRepository touristRepository){
        this.touristRepository = touristRepository;
    }

    public List<TouristAttraction> getAllAttractions(){
        return touristRepository.getAllTouristAttractions();
    }

    public TouristAttraction getTouristAttractionByName(String name){
        return touristRepository.getTouristAttractionByName(name);
    }

    public TouristAttraction addTouristAttraction(TouristAttraction touristAttraction){
        return touristRepository.addAttraction(touristAttraction);
    }

    public TouristAttraction updateTouristAttraction(TouristAttraction touristAttraction, int id){
        return touristRepository.updateAttraction(touristAttraction, id);
    }
    public TouristAttraction deleteTouristAttraction(TouristAttraction touristAttraction){
        return touristRepository.deleteAttraction(touristAttraction);
    }
}
