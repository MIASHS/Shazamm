package com.company;

import java.util.*;

/**
 * Created by Gaby on 24/02/2017.
 */
public class Jeu {

    private ArrayList<Joueur> listJoueur;
    private int nbJoueus = 2;
    private boolean finTour=false;
    private boolean finManche=false;
    private Carte[] cartesJ1 = new Carte[15];
    private Carte[] cartesJ2 = new Carte[15];
    int tableauEntier[] = new int[21];
    Boolean vert= false;
    Boolean rouge= false;



    public void debutJeu(){

        this.listJoueur= new ArrayList<Joueur>();
        int numJoueur=0;
        int pointMana=50;
        String nomJoueur;
        System.out.println("Bienvenue dans le jeu Shazamm !");

        for (int i =0; i<2; i++){

            Scanner sc= new Scanner(System.in);
            System.out.println("Veuillez renseigner le nom du joueur ");
            nomJoueur = sc.nextLine();
            Joueur j=new Joueur(nomJoueur,numJoueur,pointMana);
            listJoueur.add(j);


        }
        init();
        superPaquet();
        melanger(50);
        attaquer();



    }


//    public void init() {
//            for (int j =0; j<14;j++){
//                Carte c =new Carte(j," ");
//                this.cartesTotal2.add(c);
//                this.cartesTotal1.add(c);
//            }
//        }

    public void choixPuissance(Joueur joueur){

        Scanner sc = new Scanner(System.in);
        System.out.println("Saisissez un entier : ");
        int puissance = sc.nextInt();
        joueur.setPointMana(joueur.getPointMana()-puissance);
        
        System.out.println(" Puissance du coup "+joueur.getPuissanceCoup());
    }



    public void attaquer(){

        this.choixPuissance(listJoueur.get(0));
        this.choixPuissance(listJoueur.get(1));

    }



    public void init() {
        for (int i = 0; i < 15; i++) {
            cartesJ1[i] = new Carte(i, "\n");
            i++;
        }
        for (int i = 0; i < 15; i++) {
            cartesJ2[i] = new Carte(i, "\n");
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

    public void echangerDeuxCartes(){
        int z = (int) (Math.random() * 15.0);
        int y = (int)(Math.random() * 15.0);
        Carte surprise = cartesJ1[y];
        cartesJ1[y] = cartesJ1 [z];
        cartesJ1[z]= surprise;
        Carte surprise2 =cartesJ2[y];
        cartesJ2[y] = cartesJ1 [z];
        cartesJ2[z]= surprise2;
    }

    public void melanger(int nbFista) {
        for (int i = 0; i < nbFista; i++) {
            this.echangerDeuxCartes();
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

    public void finTour(){
        finTour=true;
    }

    public void setFinManche(){
        finManche=true;
    }


}
