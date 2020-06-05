package symulacja.participants.pedestrian;

import symulacja.mapa.PositionOccupation;

import java.util.LinkedList;
import java.util.List;

public abstract class APedestrian implements Pedestrian {

    protected int coordinateX;
    protected int firstCoordinateY;
    protected int coordinateY;
    protected PositionOccupation positionOccupation;
    protected int movingCoordinateY = 0;
    List<Integer> movingStory = new LinkedList<>();
    protected PositionOccupation mapa[][];

    public APedestrian() {
        this.coordinateX = coordinateX();
        this.coordinateY = coordinateY();
        this.firstCoordinateY = coordinateY;
        this.positionOccupation = positionOccupation;
        this.movingCoordinateY = movingCoordinateY;
        this.movingStory = new LinkedList<>();
    }

    @Override
    public void crossing(int firstCoordinateY, int coordinateY, int coordinateX, List<Integer> movingStory) throws InterruptedException {
        movingCoordinateY = firstCoordinateY;
        if (firstCoordinateY == 0)
            rightPavementCrossing(coordinateY, coordinateX, movingStory);
        else if (firstCoordinateY == 5)
            leftPavementCrossing(coordinateY, coordinateX, movingStory);
    }

    @Override
    public void leftPavementCrossing(int coordinateY, int coordinateX, List<Integer> movingStory) throws InterruptedException {
    }

    @Override
    public void rightPavementCrossing(int coordinateY, int coordinateX, List<Integer> movingStory) throws InterruptedException {
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
