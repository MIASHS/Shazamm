package com.company;

/**
 * Created by Gaby on 22/02/2017.
 */
public class Joueur {
    private String nomJoueur;
    private String couleurJoueur;
    private int numJoueur;

    public Joueur(String nomJoueur, String couleurJoueur, int numJoueur) {
        this.nomJoueur = nomJoueur;
        this.couleurJoueur = couleurJoueur;
        this.numJoueur = numJoueur;
    }

    public String getNomJoueur() {
        return nomJoueur;
    }

    public void setNomJoueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

    public String getCouleurJoueur() {
        return couleurJoueur;
    }

    public void setCouleurJoueur(String couleurJoueur) {
        this.couleurJoueur = couleurJoueur;
    }

    public int getNumJoueur() {
        return numJoueur;
    }

    public void setNumJoueur(int numJoueur) {
        this.numJoueur = numJoueur;
    }
}
