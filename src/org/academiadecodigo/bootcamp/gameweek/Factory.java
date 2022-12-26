package org.academiadecodigo.bootcamp.gameweek;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Factory {


    public static Cadet getNewCadet() {
        int zombieType = ((int)(Math.ceil(Math.random() * 4)));
        int randomY = ((int)(Math.random() * 980) + 45);
        int randomX = (int)Math.ceil(Math.random() * 2) == 1 ? 90 : 1860;
        int counter = 0;
        int speed = counter <= 15 ? 15 : (10 * (counter / 10));

        Cadet zombie;
        switch (zombieType){
        case 1:
             zombie = new ZombieOne(randomX,randomY,speed);
             counter++;
             break;
        case 2:
            zombie = new ZombieTwo(randomX,randomY,speed);
            counter++;
            break;
        case 3:
            zombie = new ZombieBoomer(randomX,randomY,speed);
            counter++;
            break;
        default:
            zombie = new ZombieDog(randomX, randomY,speed);
            counter++;
            break;
        }
        return zombie;
    }
}
