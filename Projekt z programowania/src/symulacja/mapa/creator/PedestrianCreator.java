package symulacja.mapa.creator;

import symulacja.participants.pedestrian.Pedestrian;

import java.util.List;

public interface PedestrianCreator {

    public List<Pedestrian> creatorHuman();
    public List<Pedestrian> creatorDogs();

}
