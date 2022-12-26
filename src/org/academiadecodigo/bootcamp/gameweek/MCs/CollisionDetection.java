package org.academiadecodigo.bootcamp.gameweek.MCs;

import org.academiadecodigo.bootcamp.gameweek.Cadet;
import org.academiadecodigo.bootcamp.gameweek.MC;
import org.academiadecodigo.bootcamp.gameweek.Sound;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;

public class CollisionDetection {

    private MC mc;
    private ArrayList<Cadet> cadets;

    Sound crunchSound;
    Sound hitSound;

    public CollisionDetection(MC mc, ArrayList<Cadet> cadets){
        this.cadets = cadets;
        this.mc = mc;
    }

    public boolean collision(){
        for(Cadet cadet : cadets){
            Picture cadetPicture = cadet.getPicture();
            Picture mcPicture = mc.getPicture();

            if(((mcPicture.getX() + 15 >= cadetPicture.getX() + 15 && mcPicture.getX() + 15 <= cadetPicture.getMaxX() + 5) &&
                    (mcPicture.getY() + 10 >= cadetPicture.getY() + 10 && mcPicture.getY() + 10 <= cadetPicture.getMaxY())) ||(
                    (mcPicture.getMaxX() + 5 <= cadetPicture.getMaxX() && mcPicture.getMaxX() + 5 >= cadetPicture.getX() +15 ) &&
                            (mcPicture.getMaxY() <= cadetPicture.getMaxY() && mcPicture.getMaxY() >= cadetPicture.getY() +10))

            ){
                for(Cadet cadet2 : this.cadets) {
                    cadet2.getPicture().delete();
                }
                mc.getPicture().delete();
                cadets.clear();

                crunchSound = new Sound(0);
                crunchSound.init();
                crunchSound.play();

                return true;
            }
        }
        return false;
    }

    public void CadetProjectileCollision(){
        Cadet cadet;
        for(int i = 0; i < mc.getProjectiles().size(); i++){
            Projectile p = (Projectile) mc.getProjectiles().get(i);
            for(int j = 0; j < cadets.size(); j++){
                cadet = cadets.get(j);
                Picture cadetPicture = cadet.getPicture();
                Picture projectilePicture = p.getProjectilePicture();
                if(((p.getX() + 15 >= cadetPicture.getX() + 15 && p.getX() + 15 <= cadetPicture.getMaxX() + 5) &&
                    (p.getY() + 10 >= cadetPicture.getY() + 10 && p.getY() + 10 <= cadetPicture.getMaxY())) ||(
                    (projectilePicture.getMaxX() + 5 <= cadetPicture.getMaxX() && projectilePicture.getMaxX() + 5 >= cadetPicture.getX() +15 ) &&
                            (projectilePicture.getMaxY() <= cadetPicture.getMaxY() && projectilePicture.getMaxY() >= cadetPicture.getY() +10)))
                {
                    p.hideBullet();

                    hitSound = new Sound(4);
                    hitSound.init();
                    hitSound.play();

                    mc.getProjectiles().remove(p);
                    cadetPicture.delete();
                    cadets.remove(cadet);

                }

            }
        }
    }

    public ArrayList<Cadet> getCadets() {
        return cadets;
    }
}
