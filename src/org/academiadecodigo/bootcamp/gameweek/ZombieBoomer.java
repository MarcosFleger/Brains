package org.academiadecodigo.bootcamp.gameweek;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class ZombieBoomer extends Cadet{
    public ZombieBoomer(int X, int Y, int speed) {
        setSpeed(speed);
        setAddressUp("src/rscs/New Chars/Zombie_Boomer/ZombieBoomer_Up.png");
        setAddressDown("src/rscs/New Chars/Zombie_Boomer/ZombieBoomer_Down.png");
        setAddressLeft("src/rscs/New Chars/Zombie_Boomer/ZombieBoomer_Left.png");
        setAddressRight("src/rscs/New Chars/Zombie_Boomer/ZombieBoomer_Right.png");
        setPicture(new Picture(X, Y, getAddressUp()));
        getPicture().draw();
    }
}
