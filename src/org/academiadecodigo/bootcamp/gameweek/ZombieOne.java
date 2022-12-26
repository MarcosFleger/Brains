package org.academiadecodigo.bootcamp.gameweek;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class ZombieOne extends Cadet{
    public ZombieOne(int X, int Y, int speed) {
        setSpeed(speed);
        setAddressUp("src/rscs/New Chars/Zombie_1/ZombieOne_Up.png");
        setAddressDown("src/rscs/New Chars/Zombie_1/ZombieOne_Down.png");
        setAddressLeft("src/rscs/New Chars/Zombie_1/ZombieOne_Left.png");
        setAddressRight("src/rscs/New Chars/Zombie_1/ZombieOne_Right.png");
        setPicture(new Picture(X, Y, getAddressUp()));
        getPicture().draw();
    }


}


