package symulacja.participants.pedestrian;

import symulacja.mapa.PositionOccupation;

import java.util.List;
import java.util.Random;

public class Dog extends APedestrian {

    public Dog() {
    }

    @Override
    public int coordinateX() {
        int coordinateX = 32;
        Random random = new Random();
        coordinateX = random.nextInt() % 32;
        return coordinateX;
    }

    @Override
    public int coordinateY() {
        int coordinateY = 6;
        Random random = new Random();
        coordinateY = random.nextInt() % 6;
        return coordinateY;
    }

    @Override
    public void crossing(int firstCoordinateX, int firstCoordinateY,int coordinateY, int coordinateX, List<Integer> movingStory) throws InterruptedException {
        super.crossing(firstCoordinateX, firstCoordinateY, coordinateY, coordinateX, movingStory);
    }

    @Override
    public void leftPavementCrossing(int coordinateY, int coordinateX, List<Integer> movingStory) throws InterruptedException {
        movingCoordinateY = coordinateY;
        for (int i = 1; i < 6; i++) {
            if (movingCoordinateY == 5)
                System.gc();
            else {
                movingCoordinateY++;
                movingStory.add(coordinateY);
                mapa[coordinateX][movingStory.get(movingCoordinateY) - 1] = positionOccupation.EMPTY;
                mapa[coordinateX][movingCoordinateY++] = positionOccupation.DOG;
                Thread.sleep(3000);
            }
        }
    }

    @Override
    public void rightPavementCrossing(int coordinateY, int coordinateX, List<Integer> movingStory) throws InterruptedException {
        movingCoordinateY = coordinateY;
        for (int i = 1; i < 6; i++) {
            if (movingCoordinateY == 0)
                System.gc();
            else {
                movingCoordinateY--;
                movingStory.add(coordinateY);
                mapa[coordinateX][movingStory.get(movingCoordinateY) + 1] = positionOccupation.EMPTY;
                mapa[coordinateX][movingCoordinateY++] = positionOccupation.DOG;
                Thread.sleep(3000);
            }
        }


    }

}
