package symulacja.participants.vehicle;

import symulacja.mapa.PositionOccupation;

import java.util.Random;

public class Car extends Vehicle {

    public Car(int maxSpeed) {
        super(maxSpeed);
    }

    private int speedSlowerCar;
    private int speedSlowerBicycle;



    public int coordinateX() {
        int x = 0;
        Random random = new Random();
        while (x != 2 && x != 29) {
            x = random.nextInt() % 32;
        }
        return x;
    }

    public int coordinateY() {
        if (coordinateX == 2) {
            coordinateY = 4;
        } else {
            coordinateY = 1;
        }
        return coordinateY;
    }

    @Override
    public void slowDown(int speed1, int speed2) {
        super.slowDown(speed1, speed2);
    }

    @Override
    public PositionOccupation seeObstacle(int coordinateX, int coordinateY) {
        return super.seeObstacle(coordinateX, coordinateY);
    }

    @Override
    protected int speed(int maxSpeed) {
        return super.speed(maxSpeed);
    }

    public void accelerate(int speed, int maxSpeed) {
        super.accelerate(speed, maxSpeed);
    }


    public void move(int maxSpeed) throws InterruptedException {
        if (coordinateX == 1) {
            for (; coordinateX == 31; coordinateX++) {
                Thread.sleep(maxSpeed * 1000);//inaczej bez 1000 będą milisekundy

                switch (seeObstacle(coordinateX, coordinateY)) {
                    case HUMAN:
                    case DOG:
                    case RED:
                        slowDown(maxSpeed, 0);
                        break;
                    case BICYCLE:
                        slowDown(speed, speedSlowerBicycle);
                        break;
                    case CAR:
                        slowDown(speed, speedSlowerCar);
                        break;
                    case COP:
                        slowDown(maxSpeed, PERMISSIBLE_SPEED);
                        break;
                    default:
                        accelerate(speed, maxSpeed);
                }
            }
        } else {
            for (; coordinateX == 0; coordinateX--) {

                Thread.sleep(maxSpeed * 1000);//inaczej bez 1000 będą milisekundy

                switch (seeObstacle(coordinateX, coordinateY)) {
                    case HUMAN:
                    case DOG:
                    case RED:
                        slowDown(maxSpeed, 0);
                        break;
                    case COP:
                        slowDown(maxSpeed, PERMISSIBLE_SPEED);
                        break;
                    case BICYCLE:
                        slowDown(speed, speedSlowerBicycle);
                        break;
                    case CAR:
                        slowDown(speed, speedSlowerCar);
                        break;
                    default:
                        accelerate(speed, maxSpeed);
                }
            }
        }
    }
}
