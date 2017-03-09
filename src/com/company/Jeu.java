package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Gaby on 24/02/2017.
 */
public class Jeu {

    private ArrayList<Joueur> listJoueur;
    private int nbJoueus = 2;
    private boolean finTour=false;
    private HashSet<Carte> carteJ1;
    private HashSet<Carte> cartesJ2;
    int tableauEntier[] = new int[21];



    public void debutJeu(){

        this.listJoueur= new ArrayList<Joueur>();
        int numJoueur=1;
        int pointMana=50;
        System.out.println("Bienvenue dans le jeu Shazamm !");

        for (int i =0; i<nbJoueus; i++){
            String nomJoueur;
            Scanner sc= new Scanner(System.in);
            System.out.println("Veuillez renseigner le nom du joueur ");
            nomJoueur = sc.nextLine();
            Joueur j=new Joueur(nomJoueur,numJoueur,pointMana);
            listJoueur.add(j);
            numJoueur+=1;

            couleurJoueur(j);

        }

    }

    public void couleurJoueur(Joueur joueur){
        Random ra = new Random();
        int fonction = ra.nextInt(2);
            if (fonction==1){
                System.out.println("Sorcier "+joueur.getNumJoueur()+ " est le sorcier rouge");
            }else if ((fonction==0)){
                System.out.println("Sorcier "+joueur.getNumJoueur()+ "est le sorcier vert");
            }
    }

}
