package com.company;

import java.util.*;

/**
 * Created by Gaby on 24/02/2017.
 */
public class Jeu {

    private ArrayList<Joueur> listJoueur;
    private int nbJoueus = 2;
    private boolean finTour=false;
    private Carte[] cartesJ1 = new Carte[15];
    private Carte[] cartesJ2 = new Carte[15];
    int tableauEntier[] = new int[21];
    Boolean vert= false;
    Boolean rouge= false;



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
        init();
        superPaquet();

    }


//    public void init() {
//            for (int j =0; j<14;j++){
//                Carte c =new Carte(j," ");
//                this.cartesTotal2.add(c);
//                this.cartesTotal1.add(c);
//            }
//        }

    public void attaquer(){

    }

    public void init() {

            for (int i = 0; i < 15; i++) {
                cartesJ1[i] = new Carte(i, "");
                i++;
            }for (int i = 0; i < 15; i++) {
            cartesJ2[i] = new Carte(i, " ");
            i++;
        }
        }

    public void superPaquet(){

            for (int i = 1; i < cartesJ1.length; i++) {
                System.out.print(" Connard de joueur 1 [" + i + "]=" + cartesJ1[i] + " ");
            }
            for (int i = 1; i < cartesJ2.length; i++) {
                System.out.print(" Connard de joueur 2 [" + i + "]=" + cartesJ2[i] + " ");
            }

    }


    public void couleurJoueur(Joueur joueur){
        Random ra = new Random();

        int fonction = ra.nextInt(2);
            if (fonction==1){
                rouge=true;
                vert=false;
                System.out.println("Sorcier "+joueur.getNumJoueur() + " est le sorcier rouge");

            }else{
                System.out.println("Sorcier "+joueur.getNumJoueur() + "est le sorcier vert");
                vert=true;
                rouge=false;
            }
    }



}
