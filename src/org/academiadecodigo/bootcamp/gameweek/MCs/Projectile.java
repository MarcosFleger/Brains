package org.academiadecodigo.bootcamp.gameweek.MCs;

import org.academiadecodigo.bootcamp.gameweek.Direction;
import org.academiadecodigo.bootcamp.gameweek.GameObject;
import org.academiadecodigo.bootcamp.gameweek.Map;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Projectile extends GameObject {
    private int x;
    private int y;
    private int speed;
    private boolean visible;
    private Direction direction;
    private Picture projectilePicture;

    public Projectile(int x, int y, Direction direction){
        this.x = x;
        this.y = y;
        speed = 30;
        visible = true;
        this.direction = direction;
        projectilePicture = new Picture(x,y,"src/rscs/OtherPics/Banana.png" );
        projectilePicture.draw();

    }

    public void update() {

        switch (direction){
            case RIGHT:
                x += speed;
                projectilePicture.translate(speed,0);
                break;
            case LEFT:
                x -= speed;
                projectilePicture.translate(-1 * speed, 0);
                break;
            case UP:
                y -= speed;
                projectilePicture.translate(0,-1 * speed);
                break;
            case DOWN:
                y += speed;
                projectilePicture.translate(0, speed);
        }

        if (x >= (Map.getMapWidth() - 89) || x <= 0 || y <= 0 || y >= Map.getMapHeight() - 90) {
            visible = false;
        }
    }

    public int getSpeed() {
        return speed;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public Picture getProjectilePicture() {
        return projectilePicture;
    }

    public boolean isVisible(){
        return visible;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }


    public void hideBullet(){
            projectilePicture.delete();
    }
}
