package org.academiadecodigo.bootcamp.gameweek;

import org.academiadecodigo.bootcamp.gameweek.GameObject;
import org.academiadecodigo.bootcamp.gameweek.MCs.Projectile;
import org.academiadecodigo.bootcamp.gameweek.Position;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;

import static org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent.*;
import static org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType.KEY_PRESSED;
import static org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType.KEY_RELEASED;

public class MC extends GameObject implements KeyboardHandler {
    private Picture picture = new Picture(Map.getMapWidth()/2, Map.getMapHeight()/2,"src/rscs/New Chars/GunMen/Gunmen_Up.png");
    private Direction direction;
    private int speed = 11;
    private Keyboard keyboard = new Keyboard(this);
    private ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
    Sound shootSound;
    public MC(){
        setAddressUp("src/rscs/New Chars/GunMen/Gunmen_Up.png");
        setAddressDown("src/rscs/New Chars/GunMen/Gunmen_Down.png");
        setAddressLeft("src/rscs/New Chars/GunMen/Gunmen_Left.png");
        setAddressRight("src/rscs/New Chars/GunMen/Gunmen_Right.png");
        picture.draw();
    }
    private String addressUp;
    private String addressDown;
    private String addressLeft;
    private String addressRight;
    private boolean dontShoot;

    public void shoot() {
        if(!dontShoot) {
            Projectile p = new Projectile(picture.getX() + picture.getWidth() / 2, picture.getY() + picture.getHeight() / 2, direction);
            projectiles.add(p);

            shootSound = new Sound(3);
            shootSound.init();
            shootSound.play();
        }
    }

    public ArrayList getProjectiles() {
        return projectiles;
    }


    public int getWidth(){
        return picture.getWidth();
    }

    public int getHeight(){
        return picture.getHeight();
    }

    public void init(){

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KEY_RIGHT);
        right.setKeyboardEventType(KEY_PRESSED);
        keyboard.addEventListener(right);

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KEY_LEFT);
        left.setKeyboardEventType(KEY_PRESSED);
        keyboard.addEventListener(left);

        KeyboardEvent upPressed = new KeyboardEvent();
        upPressed.setKey(KEY_UP);
        upPressed.setKeyboardEventType(KEY_PRESSED);
        keyboard.addEventListener(upPressed);

        KeyboardEvent downPressed = new KeyboardEvent();
        downPressed.setKey(KEY_DOWN);
        downPressed.setKeyboardEventType(KEY_PRESSED);
        keyboard.addEventListener(downPressed);

        KeyboardEvent space = new KeyboardEvent();
        space.setKey(KEY_SPACE);
        space.setKeyboardEventType(KEY_RELEASED);
        keyboard.addEventListener(space);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()){
            case KEY_LEFT:
                if(picture.getX() <= 0){
                    break;
                }
                picture.translate(-speed,0);
                picture.load(getAddressLeft());
                direction = Direction.LEFT;
                break;
            case KEY_RIGHT:
                if(picture.getX() >= Map.getMapWidth() - 89) {
                    break;
                }
                picture.translate(speed,0);
                picture.load(getAddressRight());
                direction = Direction.RIGHT;
                break;
            case KEY_DOWN:
                if(picture.getY() >= Map.getMapHeight() - 90){
                    break;
                }
                picture.translate(0,speed);
                picture.load(getAddressDown());
                direction = Direction.DOWN;
                break;
            case KEY_UP:
                if (picture.getY() <= 0){
                    break;
                }
                picture.translate(0,-speed);
                picture.load(getAddressUp());
                direction = Direction.UP;

                break;

            //case KEY_SPACE:

                //break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        if(keyboardEvent.getKey() == KEY_SPACE){
            shoot();
        }
    }

    public Picture getPicture() {
        return picture;
    }

    public String getAddressUp() {
        return addressUp;
    }

    public void setAddressUp(String addressUp) {
        this.addressUp = addressUp;
    }

    public String getAddressDown() {
        return addressDown;
    }

    public void setAddressDown(String addressDown) {
        this.addressDown = addressDown;
    }

    public String getAddressLeft() {
        return addressLeft;
    }

    public void setAddressLeft(String addressLeft) {
        this.addressLeft = addressLeft;
    }

    public String getAddressRight() {
        return addressRight;
    }

    public void setAddressRight(String addressRight) {
        this.addressRight = addressRight;
    }

    public void setDontShoot(boolean value){
        dontShoot = value;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
}
