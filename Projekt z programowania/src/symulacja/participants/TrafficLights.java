package symulacja.participants;

import symulacja.mapa.PositionOccupation;

public class TrafficLights {
    public long lightFrequency;
    public int coordinateX;
    public int coordinateY;
    public boolean light;
    private PositionOccupation[][] mapa;
    private PositionOccupation color;

    public TrafficLights(long lightFrequency, int coordinateX, int coordinateY, boolean light) {
        this.lightFrequency = lightFrequency;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.light = light;
    }

    public void changeColour(int coordinateX, int coordinateY, long lightFrequency) throws InterruptedException {
        light = true;
        mapa[this.coordinateY][this.coordinateY] = color.GREEN;

        while (1 > 0) {
            Thread.sleep(lightFrequency * 1000);
            light = !light;

            if (light == true) {
                mapa[this.coordinateX][this.coordinateY] = color.GREEN;
            } else {
                mapa[coordinateX][coordinateY] = color.RED;
            }
        }
    }
}
