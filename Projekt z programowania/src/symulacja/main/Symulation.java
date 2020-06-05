package symulacja.main;

import symulacja.mapa.MapSimple;
import symulacja.mapa.Mapa;
import symulacja.mapa.creator.MapaCreator;
import symulacja.mapa.creator.PedestrianCreator;
import symulacja.mapa.creator.PedestrianCreatorList;
import symulacja.mapa.creator.VehicleCreatorList;
import symulacja.participants.pedestrian.Pedestrian;
import symulacja.participants.vehicle.Bicycle;
import symulacja.participants.vehicle.Car;
import symulacja.participants.vehicle.VehicleFunction;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Symulation {

    Konsola konsola;
    Mapa map;
    MapSimple mapa;
    PedestrianCreatorList pedestrianCreator;
    VehicleCreatorList vehicleCreator;

    public Symulation(Mapa map, PedestrianCreatorList pedestrianCreator, VehicleCreatorList vehicleCreator) {
        this.mapa = new MapSimple();
        this.pedestrianCreator = pedestrianCreator;
        this.vehicleCreator = vehicleCreator;
    }

    public static void main(String[] args) throws InterruptedException {

        MapSimple mapa = new MapSimple();
        Konsola konsola = new Konsola();
        VehicleCreatorList vehicleCreator = new VehicleCreatorList(konsola.numberCar, konsola.numberBicycle);
        PedestrianCreatorList pedestrianCreator = new PedestrianCreatorList(konsola.numberHuman, konsola.numberDog);
        Symulation symulation = new Symulation(mapa, pedestrianCreator, vehicleCreator );

        List<VehicleFunction> carList;
        List<VehicleFunction> bicycleList;
        List<Pedestrian> humanList;
        List<Pedestrian> dogList;

        carList = vehicleCreator.creatorCars(mapa, konsola.maxSpeedCar);
        bicycleList = vehicleCreator.creatorCars(mapa, konsola.maxSpeedBicycle);
        humanList = pedestrianCreator.creatorHuman();
        dogList = pedestrianCreator.creatorDogs();





        }
    }


//        int indexBicycle = 0;
//        int indexCar = 0;
//
//        for (int i = 0; i < konsola.numberVehicle; i++) {
//            int x;
//            Random random = new Random();
//            x = random.nextInt() % 2;
//            if (x == 1) {
//                Car car = new Car(konsola.maxSpeedCar);
//                listCar[indexCar] = car;
//                listCar[indexCar].coordinateX();
//                listCar[indexCar].coordinateY();
//                indexCar++;
//            } else {
//                Bicycle bicycle = new Bicycle(konsola.maxSpeedBicycle);
//                listBicycle[indexBicycle] = bicycle;
//                listBicycle[indexBicycle].coordinateX();
//                listBicycle[indexBicycle].coordinateY();
//                indexBicycle++;
//            }
//            for (int y = 0; ; y++) {
//                listBicycle[y].move(konsola.maxSpeedBicycle);
//                System.out.println("Rower nr" + (y + 1) + "znajduje się na mapie na pozycji x" + listBicycle[y].coordinateX + " i pozycji y" + listBicycle[y].coordinateY);
//            }
//            for (int y = 0; y != indexCar; y++) {
//                listCar[y].move(konsola.maxSpeedCar);
//                System.out.println("Auto nr" + (y + 1) + "znajduje się na mapie na pozycji x" + listCar[y].coordinateX +
//                "i pozycji y" + listCar[y].coordinateY);
//            }
//            for (int y = 0; y != indexBicycle; y++) {
//                for (int w = 0; w != indexBicycle; w++) {
//                    if (listBicycle[y].coordinateX == listCar[w].coordinateX &&
//                            listBicycle[y].coordinateY == listCar[w].coordinateY) {
//                        System.out.println("NASTĄPILA STŁUCZKA! DROGA NIE JEST BEZPIECZNA");
//                        System.exit(0);
//                    }
//                }
//            }

