package org.academiadecodigo.bootcamp.gameweek;

import org.academiadecodigo.bootcamp.gameweek.Cadet;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class ZombieTwo extends Cadet {
    public ZombieTwo(int X, int Y, int speed) {
        setSpeed(speed);
        setAddressUp("src/rscs/New Chars/Zombie_2/ZombieTwo_Up.png");
        setAddressDown("src/rscs/New Chars/Zombie_2/ZombieTwo_Down.png");
        setAddressLeft("src/rscs/New Chars/Zombie_2/ZombieTwo_Left.png");
        setAddressRight("src/rscs/New Chars/Zombie_2/ZombieTwo_Right.png");
        setPicture(new Picture(X, Y, getAddressUp()));
        getPicture().draw();
    }


}