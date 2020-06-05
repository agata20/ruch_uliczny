package symulacja.participants.vehicle;

import symulacja.mapa.PositionOccupation;

import java.util.Random;

public class Bicycle extends Vehicle {

    public Bicycle(int maxSpeed) {
        super(maxSpeed);
    }

    public int coordinateX() {
        int x = 0;
        Random random = new Random();
        while (x != 1 && x != 30) {
            x = random.nextInt() % 32;
        }
        return x;
    }

    public int coordinateY() {
        if (coordinateX == 1) {
            coordinateY = 4;
        } else {
            coordinateY = 1;
        }
        return coordinateY;
    }

    public void accelerate(int speed, int maxSpeed) {
        super.accelerate(speed, maxSpeed);
    }

    public void slowDown(int speed, int maxSpeed) {
        super.slowDown(speed, maxSpeed);
    }

    @Override
    public PositionOccupation seeObstacle(int coordinateX, int coordinateY) {
        return super.seeObstacle(coordinateX, coordinateY);
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
                    case CAR:
                        slowDown(maxSpeed, PERMISSIBLE_SPEED);
                        break;
                    default:
                        accelerate(speed, maxSpeed);

                }
            }
        }
    }

}
