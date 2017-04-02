package com.company;

import jdk.nashorn.internal.scripts.JO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Gaby on 24/02/2017.
 */
public class Carte {

    private int numCarte;
    private String nomCarte;


    public Carte(int numCarte, String nomCarte) {
        this.numCarte = numCarte;
        this.nomCarte = nomCarte;
    }

    public String toString() {
        if (numCarte == 1) {
            return "carte Mutisme";
        } else if (numCarte == 2) {
            return "carte Clone";
        } else if (numCarte == 3) {
            return "carte Larcin";
        } else if (numCarte == 4) {
            return "carte Fin de manche";
        } else if (numCarte == 5) {
            return "carte Milieu";
        } else if (numCarte == 6) {
            return "carte Recyclage";
        } else if (numCarte == 7) {
            return "carte Boost attaque";
        } else if (numCarte == 8) {
            return "carte Double dose";
        } else if (numCarte == 9) {
            return "carte Qui perd gagne";
        } else if (numCarte == 10) {
            return "carte Brasier";
        } else if (numCarte == 11) {
            return "carte Résistance";
        } else if (numCarte == 12) {
            return "carte Harpagon";
        } else if (numCarte == 13) {
            return "carte Boost réserve";
        } else if (numCarte == 14) {
            return "carte Aspiration";
        }
        return ""+numCarte;
    }

    public void pouvoirCarte(Joueur j, Plateau plateau){
        Scanner sc = new Scanner(System.in);
        System.out.println("Saisissez un entier : ");
        int choixCarte = sc.nextInt();

        if (choixCarte == 1) { // Mutisme

            j.setPuissanceCoup(0);
        } else if (choixCarte == 2) { //carte Clone

        } else if (choixCarte == 3) { // carte Larcin

        } else if (choixCarte == 4) { //carte Fin de manche

        } else if (choixCarte == 5) { //carte Milieu

            plateau.setPlaceMur(10);

        } else if (choixCarte == 6) {  //carte Recyclage
            Scanner sc2 = new Scanner(System.in);
            System.out.println("P ou M ? ");
            int choix = sc.nextInt();

        } else if (choixCarte == 7) {//carte Boost
            j.setPuissanceCoup(j.getPuissanceCoup()+7);
        } else if (choixCarte == 8) { // Double dose
            j.setPuissanceCoup(j.getPuissanceCoup()*2);
        } else if (choixCarte == 9) { //carte Qui perd gagne

        } else if (choixCarte == 10) { //carte Brasier

        } else if (choixCarte == 11) { // carte Résistance

        } else if (choixCarte == 12) { // Harpagon

        } else if (choixCarte == 13) { // Boost réserve
            j.setPointMana(j.getPointMana()+13);
        } else if (choixCarte == 14) { //Aspiration

        }

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
