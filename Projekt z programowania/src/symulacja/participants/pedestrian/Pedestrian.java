package symulacja.participants.pedestrian;

import symulacja.participants.RandomPositionOccupation;

import java.util.List;

public interface Pedestrian extends RandomPositionOccupation {

    void crossing(int firstCoordinateY, int coordinateY, int coordinateX, List<Integer> movingStory) throws InterruptedException;

    void leftPavementCrossing(int coordinateY, int coordinateX, List<Integer> movingStory) throws InterruptedException;

    void rightPavementCrossing(int coordinateY, int coordinateX, List<Integer> movingStory) throws InterruptedException;
}
