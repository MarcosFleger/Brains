package org.academiadecodigo.bootcamp.gameweek;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class ZombieDog extends Cadet {
    public ZombieDog(int X, int Y, int speed) {
        setSpeed(speed);
        setAddressUp("src/rscs/New Chars/Zombie_Dog/ZombieDog_Up.png");
        setAddressDown("src/rscs/New Chars/Zombie_Dog/ZombieDog_Down.png");
        setAddressLeft("src/rscs/New Chars/Zombie_Dog/ZombieDog_Left.png");
        setAddressRight("src/rscs/New Chars/Zombie_Dog/ZombieDog_Right.png");
        setPicture(new Picture(X, Y, getAddressUp()));
        getPicture().draw();
    }
}
