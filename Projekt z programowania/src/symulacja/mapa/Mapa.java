package symulacja.mapa;

import symulacja.participants.Cop;
import symulacja.participants.TrafficLights;
import symulacja.participants.pedestrian.Dog;
import symulacja.participants.pedestrian.Human;
import symulacja.participants.vehicle.Bicycle;
import symulacja.participants.vehicle.Car;

public interface Mapa {

        public PositionOccupation[][] makeMap();
        boolean settleHuman(Human human);
        boolean settleDog(Dog dog);
        boolean settleBicycle(Bicycle bicycle);
        boolean settleCar(Car car);
        boolean settleCop(Cop cop);
        boolean TrafficLight(TrafficLights trafficLights);

}
