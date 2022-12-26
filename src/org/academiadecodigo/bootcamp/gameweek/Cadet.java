package org.academiadecodigo.bootcamp.gameweek;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Cadet extends GameObject {
    //private Position position = new Position();
    private Picture picture;
    private Direction direction = null;
    private int speed = 10;
    private int numberOfMoves = 0;

    private String addressUp;
    private String addressDown;
    private String addressLeft;
    private String addressRight;

    public void move(int playerX, int playerY){
        followPlayer(playerX, playerY);
        if (numberOfMoves < 3) {
            switch (direction) {
                case UP:
                    if (picture.getY() <= speed) {
                        setDirection(Direction.DOWN);
                        return;
                    }
                    picture.load(addressUp);
                    picture.translate(0, (-1 * speed));
                    break;
                case DOWN:
                    if (picture.getY() >= (600 - speed - 10)) {
                        setDirection(Direction.UP);
                        return;
                    }
                    picture.load(addressDown);
                    picture.translate(0, speed);
                    numberOfMoves++;
                    break;
                case LEFT:
                    if (picture.getX() <= speed) {
                        setDirection(Direction.RIGHT);
                        return;
                    }
                    picture.load(addressLeft);
                    picture.translate((-1 * speed), 0);
                    numberOfMoves++;
                    break;
                case RIGHT:
                    if (picture.getX() >= (1750 - speed - 5)) {
                        setDirection(Direction.LEFT);
                        return;
                    }
                    picture.load(addressRight);
                    picture.translate(speed, 0);
                    numberOfMoves++;
                    break;
                default:
                    if (picture.getY() <= speed) {
                        setDirection(Direction.DOWN);
                        return;
                    }
                    picture.load(getAddressUp());
                    picture.translate(0, (-1 * speed));
                    numberOfMoves++;
                    break;

            }
        } else {
            numberOfMoves = 0;
            setDirection();
            return;
        }
    }

    public void followPlayer(int playerX, int playerY){

        /*
        if(((mcPicture.getX() + 15 >= cadetPicture.getX() + 15 && mcPicture.getX() + 15 <= cadetPicture.getMaxX() + 5) &&
                (mcPicture.getY() + 10 >= cadetPicture.getY() + 10 && mcPicture.getY() + 10 <= cadetPicture.getMaxY())) ||(
                (mcPicture.getMaxX() + 5 <= cadetPicture.getMaxX() && mcPicture.getMaxX() + 5 >= cadetPicture.getX() +15 ) &&
                        (mcPicture.getMaxY() <= cadetPicture.getMaxY() && mcPicture.getMaxY() >= cadetPicture.getY() +10))

        ){
        */

        if(picture.getX() < playerX){
            setDirection(Direction.RIGHT);
            return;
        } else if (picture.getX() > playerX + 50){
            setDirection(Direction.LEFT);
            return;
        }if (picture.getY() < playerY) {
            setDirection(Direction.DOWN);
            return;
        }else if (picture.getY() > playerY + 50){
            setDirection(Direction.UP);
            return;
        }
    }

    public void setDirection(){
        Direction newDirection = Direction.values()[(int)(Math.random() * Direction.values().length)];
        direction = newDirection;
    }
    public void setDirection(Direction newDirection){



        direction = newDirection;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public String getAddressUp() {
        return addressUp;
    }

    public String getAddressDown() {
        return addressDown;
    }

    public String getAddressLeft() {
        return addressLeft;
    }

    public String getAddressRight() {
        return addressRight;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setAddressUp(String addressUp) {
        this.addressUp = addressUp;
    }

    public void setAddressDown(String addressDown) {
        this.addressDown = addressDown;
    }

    public void setAddressLeft(String addressLeft) {
        this.addressLeft = addressLeft;
    }

    public void setAddressRight(String addressRight) {
        this.addressRight = addressRight;
    }
}



