package com.company;

/**
 * Created by Gaby on 20/03/2017.
 */
public class Plateau {
    int tailleTab=21;
    String[] plateauBase = new String[tailleTab]; // 2 sentinelles
    double placeMur = (tailleTab/2);
    double placeJ1 = placeMur-3;
    double placeJ2= placeMur+3;

    public Plateau() {

    }

    public String[] getPlateauBase() {
        return plateauBase;
    }

    public void setPlateauBase(String[] plateauBase) {
        this.plateauBase = plateauBase;
    }

    public int getTailleTab() {
        return tailleTab;
    }

    public void setTailleTab(int tailleTab) {
        this.tailleTab = tailleTab;
    }

    public double getPlaceMur() {
        return placeMur;
    }

    public void setPlaceMur(double placeMur) {
        this.placeMur = placeMur;
    }

    public double getPlaceJ1() {
        return placeJ1;
    }

    public void setPlaceJ1(double placeJ1) {
        this.placeJ1 = placeJ1;
    }

    public double getPlaceJ2() {
        return placeJ2;
    }

    public void setPlaceJ2(double placeJ2) {
        this.placeJ2 = placeJ2;
    }
}
