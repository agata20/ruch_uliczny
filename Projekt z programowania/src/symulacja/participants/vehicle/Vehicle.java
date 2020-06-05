package symulacja.participants.vehicle;

import symulacja.mapa.PositionOccupation;

public class Vehicle extends VehicleProperties implements VehicleFunction{

    public Vehicle(int maxSpeed, int speed, int coordinateX, int coordinateY) {
        super(maxSpeed,speed, coordinateX, coordinateY);
    }

    @Override
    public int speed(int maxSpeed) {
        return 0;
    }

    @Override
    public void move(int speed) throws InterruptedException {

    }

    public void accelerate(int speed, int maxSpeed) {
        if (speed < maxSpeed) {
            speed = speed * 2;
        }
    }

    public void slowDown(int speed, int safeSpeed) {
        if (speed > safeSpeed) {
            speed = speed / 2;
        }
    }

    public PositionOccupation seeObstacle(int coordinateX, int coordinateY) {
        if (coordinateX == 1) {
            for (int i = 1; i == TIME_REACTION; i++)
                for (int j = 0; j <= 4; j++) {
                    if (Mapa[coordinateX + i][coordinateY - j] != positionOccupation.EMPTY) {
                        return Mapa[coordinateX + i][coordinateY - j];
                    }
                    if (i == TIME_REACTION && j == 4) {
                     return positionOccupation.EMPTY;
                    }
                }
        } else {
            for (int i = 1; i == TIME_REACTION; i++)
                for (int j = 0; j <= 4; j++) {
                    if (Mapa[coordinateX - i][coordinateY + j] != positionOccupation.EMPTY) {
                        return Mapa[coordinateX - i][coordinateY + j];
                    }
                    if (i == TIME_REACTION && j == 4) {
                        return positionOccupation.EMPTY;
                    }
                }
        }

            return positionOccupation.EMPTY;
    }
}
