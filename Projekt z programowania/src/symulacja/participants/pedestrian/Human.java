package symulacja.participants.pedestrian;

import symulacja.mapa.PositionOccupation;

import java.util.List;
import java.util.Random;

public class Human extends APedestrian {

    public Human() {
    }

    @Override
    public void crossing(int firstCoordinateX, int firstCoordinateY,int coordinateY, int coordinateX, List<Integer> movingStory) throws InterruptedException {
    }


    public int coordinateX() {
        int x = 0;
        Random random = new Random();
        while (x != 2 && x != 8 && x != 11 && x != 12 && x != 13 && x != 18 && x != 19 && x != 20 && x != 25 && x != 30) {
            x = random.nextInt() % 32;
        }
        return x;
    }

    public int coordinateY() {
        int coordinateY = 1;
        Random random = new Random();
        while (coordinateY != 0 && coordinateY != 5) {
            coordinateY = random.nextInt() % 6;
        }
        return coordinateY;
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
                mapa[coordinateX][movingCoordinateY++] = positionOccupation.HUMAN;
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
                movingStory.add(movingCoordinateY);
                mapa[coordinateX][movingStory.get(movingCoordinateY) + 1] = positionOccupation.EMPTY;
                mapa[coordinateX][movingCoordinateY++] = positionOccupation.HUMAN;
                Thread.sleep(3000);
            }
        }


    }
}