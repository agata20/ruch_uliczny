package symulacja.participants.vehicle;

import symulacja.mapa.PositionOccupation;
import symulacja.participants.RandomPositionOccupation;

import java.util.Random;

public class VehicleProperties implements RandomPositionOccupation {

    public int maxSpeed;
    public int speed;
    public final int PERMISSIBLE_SPEED = 50;
    public final int TIME_REACTION = 10;
    public int coordinateX;
    public int coordinateY;
    protected PositionOccupation[][] Mapa;
    protected PositionOccupation positionOccupation;

    public VehicleProperties(int maxSpeed,int speed, int coordinateX, int coordinateT) {
        this.maxSpeed = maxSpeed;
        this.speed = speed(maxSpeed);
        this.coordinateX = coordinateX();
        this.coordinateY = coordinateY();

    }

    protected int speed(int maxSpeed) {
        Random random = new Random();
        speed = random.nextInt() % maxSpeed;
        Random random1 = new Random();
        return speed;
    }


    @Override
    public int coordinateX() {
        return coordinateX;
    }

    @Override
    public int coordinateY() {
        return coordinateY;
    }
}
