package com.company;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Gaby on 24/02/2017.
 */
public class Carte {

    private int numCarte;
    private String nomCarte;
    private HashSet<Carte> carteJ1;
    private HashSet<Carte> cartesJ2;

    public Carte(int numCarte, String nomCarte) {
        this.numCarte = numCarte;
        this.nomCarte = nomCarte;
    }

    public int getNumCarte() {
        return numCarte;
    }

    public void setNumCarte(int numCarte) {
        this.numCarte = numCarte;
    }

    public String getNomCarte() {
        return nomCarte;
    }

    public void setNomCarte(String nomCarte) {
        this.nomCarte = nomCarte;
    }


}
