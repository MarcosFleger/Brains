package org.academiadecodigo.bootcamp.gameweek;

import org.academiadecodigo.bootcamp.gameweek.MCs.CollisionDetection;
import org.academiadecodigo.bootcamp.gameweek.MCs.Projectile;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;


import java.util.ArrayList;

import static org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent.*;
import static org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent.KEY_1;
import static org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType.KEY_PRESSED;

public class Game implements KeyboardHandler{

    private final int N_ZOMBIES = 5;
    //private Cadet[] cadets = new Cadet[1];
    private ArrayList<Cadet> cadets = new ArrayList<Cadet>();
    private Picture GameOver = new Picture(0,0,"src/rscs/OtherPics/GameOver.jpg");

    private MC player = new MC();
    private Map background;
    private boolean enterNotPressed = true;
    private CollisionDetection detection;
    private Text bestTime;
    private boolean restart = true;
    Keyboard keyboard = new Keyboard(this);

    Sound lavenderSound;
    Sound gameOverSound;

    public Game(){

    }

    public void init(){
        player.init();

        KeyboardEvent enter = new KeyboardEvent();
        enter.setKey(KEY_1);
        enter.setKeyboardEventType(KEY_PRESSED);
        keyboard.addEventListener(enter);

        KeyboardEvent restart = new KeyboardEvent();
        restart.setKey(KEY_R);
        restart.setKeyboardEventType(KEY_PRESSED);
        keyboard.addEventListener(restart);

    }

    public void start() throws InterruptedException{
        Text timer;
        long timerValue;
        long startTime = System.currentTimeMillis();
        long stopTime;
        boolean gameOver;

        startMenu();

        for (int i = 0; i < N_ZOMBIES; i++) {
            cadets.add(Factory.getNewCadet());       /** Change to FactorY */
        }
        detection = new CollisionDetection(player, cadets);

        lavenderSound = new Sound(2);
        lavenderSound.init();
        lavenderSound.play();

        while (true) {
            stopTime = System.currentTimeMillis();
            timerValue = ((stopTime - startTime) / 1000);
            timer = new Text(1720,30,"Timer: " + String.valueOf(timerValue) + "s");
            timer.setColor(Color.WHITE);
            timer.grow(20, 10);
            timer.draw();

            ArrayList projectiles = player.getProjectiles();
            for (int i = 0; i < projectiles.size(); i++) {
                Projectile p = (Projectile) projectiles.get(i);
                if (p.isVisible() == true) {
                    p.update();
                } else {
                    ((Projectile) projectiles.get(i)).hideBullet();
                    projectiles.remove(i);
                }
            }
            //System.out.println("Took : " + ((stopTime - startTime) / 1000) + "s");
            Thread.sleep(50);
            moveAllCadets();
            if(timerValue % 10 == 0){
                if(cadets.size() < 10) {
                    cadets.add(Factory.getNewCadet());
                    //Thread.sleep(25);
                }
            }
            timer.delete();

            detection.CadetProjectileCollision();
            if(detection.collision()){
                player.setDontShoot(true);
                lavenderSound.stop();
                gameOver = gameOver(startTime);

                cadets.clear();
                detection.getCadets().clear();
                bestTime.delete();
                GameOver.delete();
                player.setPicture(new Picture(Map.getMapWidth()/2, Map.getMapHeight()/2,"src/rscs/New Chars/GunMen/Gunmen_Up.png"));
                player.getPicture().draw();
                //player = null;
                //player = new MC();
                start();
                //player.setDontShoot(gameOver);


                break;
            }
        }
    }

    public void moveAllCadets(){
        for (Cadet cadet : cadets){
            cadet.move(player.getPicture().getX(), player.getPicture().getY());
        }
    }

    /**
     Shows a Black Screen and the best time upon Collision
     */
    private boolean gameOver(long startTime){

        gameOverSound = new Sound(1);
        gameOverSound.init();
        gameOverSound.play();

        //hide background;
        //background.getBackground().delete();
        //hide player
        player.getPicture().delete();
        GameOver.draw();
        //hide all cadets
        for (Cadet cadet : cadets){
            cadet.getPicture().delete();
        }
        for(int i = 0; i < player.getProjectiles().size(); i++){
            Projectile projectile = (Projectile) player.getProjectiles().get(i);
            projectile.getProjectilePicture().delete();
        }

        long stopTime2 = System.currentTimeMillis();

        //black screen
        //Rectangle gameOverScreen = new Rectangle(0, 0, Map.getMapWidth(),Map.getMapHeight());
        //gameOverScreen.setColor(Color.BLACK);

        //game over text
        Text gameOver = new Text(Map.getMapWidth()/2,Map.getMapHeight()/2 + 20, "GAME OVER");
        gameOver.setColor(Color.WHITE);
        gameOver.grow(100,50);

        //best time text
        bestTime = new Text(Map.getMapWidth()/2 -20,Map.getMapHeight()/2 + 200,"Best Time : "+String.valueOf((stopTime2 - startTime)/1000)+"s");
        bestTime.setColor(Color.WHITE);
        bestTime.grow(50,25);

        //show black screen, game over and best time (score)
        //gameOverScreen.fill();
        //gameOver.draw();
        //bestTime.draw();

        while(restart){
            bestTime.draw();
            //setNotRestart(false);
            //System.out.println("Press R to restart");
        }
        setNotRestart(true);

        return true;

    }

    private void startMenu(){

        //black screen
        Picture menuScreen = new Picture(0,0, "src/rscs/OtherPics/StartPage.jpg");


        while(enterNotPressed){
            menuScreen.draw();


        }
        menuScreen.delete();
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent){
        switch (keyboardEvent.getKey()) {
            case KEY_1:
                enterNotPressed = false;
                break;
            case KEY_R:
                setNotRestart(false);
                player.setDontShoot(false);
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public void setNotRestart(boolean notRestart) {
        this.restart = notRestart;
    }
}
