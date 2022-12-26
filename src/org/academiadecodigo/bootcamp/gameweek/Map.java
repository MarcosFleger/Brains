package org.academiadecodigo.bootcamp.gameweek;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Map {
    private static int mapWidth;
    private static int mapHeight;
    private Picture background;
    private Obstacles[] obstacles;

    public Map(){
        background = new Picture(0,0,"src/rscs/Map/Graveyard.png");
        background.draw();
        mapWidth = background.getMaxX();
        mapHeight = background.getMaxY();

    }
    public static int getMapWidth(){
        return mapWidth;
    }

    public static int getMapHeight() {
        return mapHeight;
    }

    public Picture getBackground() {
        return background;
    }
}
