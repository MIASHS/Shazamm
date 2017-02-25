package com.company;

/**
 * Created by Gaby on 22/02/2017.
 */
public class Joueur {
    private String nomJoueur;
    private int numJoueur;
    private int pointMana=28;

    public Joueur(String nomJoueur, int numJoueur, int pointMana) {
        this.nomJoueur = nomJoueur;
        this.numJoueur = numJoueur;
        this.pointMana= pointMana;
    }

    public String getNomJoueur() {
        return nomJoueur;
    }

    public void setNomJoueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

    public int getNumJoueur() {
        return numJoueur;
    }

    public void setNumJoueur(int numJoueur) {
        this.numJoueur = numJoueur;
    }

    public int getPointMana(){return pointMana;}

    public void setPointMana(int pointMana){this.pointMana=pointMana;}
}
