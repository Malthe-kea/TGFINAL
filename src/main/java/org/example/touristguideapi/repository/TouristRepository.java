package org.example.touristguideapi.repository;

import org.example.touristguideapi.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class TouristRepository {
    private final ArrayList<TouristAttraction> attractionArrayList = new ArrayList<>();

    public TouristRepository() {
        populateAttractions();
    }

    public void populateAttractions() {

        TouristAttraction touristAttraction1 = new TouristAttraction("rundetårn", "Et højt rundt tårn",123);
        TouristAttraction touristAttraction2 = new TouristAttraction("marmorkirken", "en kirke lavet af marmor",234);
        TouristAttraction touristAttraction3 = new TouristAttraction("Christiansborg", "denne borg er lavet af christian",345);
        TouristAttraction touristAttraction4 = new TouristAttraction("Fede finn", "ofte set med sine funny boissss",456);
        attractionArrayList.add(touristAttraction1);
        attractionArrayList.add(touristAttraction2);
        attractionArrayList.add(touristAttraction3);
        attractionArrayList.add(touristAttraction4);
    }

    public ArrayList<TouristAttraction> getAllTouristAttractions() {
        return attractionArrayList;
    }

    public TouristAttraction getTouristAttractionByName(String name) {
        for (TouristAttraction touristAttraction : attractionArrayList) {
            if (touristAttraction.getName().equals(name)) {
                return touristAttraction;
            }
        }
        return null;
    }

    public TouristAttraction addAttraction(TouristAttraction touristAttraction) {
        attractionArrayList.add(touristAttraction);
        return touristAttraction;
    }

    public TouristAttraction updateAttraction(TouristAttraction touristAttraction,int id) {
        for (TouristAttraction t : attractionArrayList) {
            if (t.getId() == id) {
                t.setName(touristAttraction.getName());
                return t;
            }
        }
        return null;
    }
    public TouristAttraction deleteAttraction(TouristAttraction touristAttraction) {
        for (TouristAttraction t : attractionArrayList) {
            if (t.getName().equalsIgnoreCase(touristAttraction.getName())) {
                attractionArrayList.remove(t);
                return t;
            }
        }
        return null;
    }

}
