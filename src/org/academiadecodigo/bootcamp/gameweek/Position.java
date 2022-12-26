package org.academiadecodigo.bootcamp.gameweek;

public class Position {
    private double x;
    private double y;


    public Position(){
        x = (Math.random() * Map.getMapWidth());
        y = (Math.random() * Map.getMapHeight());
    }
    public Position(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void move(){

    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
