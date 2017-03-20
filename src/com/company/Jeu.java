package com.company;

import java.awt.*;
import java.util.*;

/**
 * Created by Gaby on 24/02/2017.
 */
public class Jeu {

    private ArrayList<Joueur> listJoueur;
    private int nbJoueus;
    private int nbManches;
    private int nbTours;
    private boolean finTour=false;
    private boolean finManche=false;
    private Carte[] cartesJ1 = new Carte[15];
    private Carte[] cartesJ2 = new Carte[15];

    Boolean vert= false;
    Boolean rouge= false;



    public void debutJeu(){

        this.listJoueur= new ArrayList<Joueur>();
        int numJoueur=0;
        int pointMana=50;
        String nomJoueur;
        System.out.println("Bienvenue dans le jeu Shazamm !");

        for (int i =1; i<3; i++){

            Scanner sc= new Scanner(System.in);
            System.out.println("Veuillez renseigner le nom du joueur ");
            nomJoueur = sc.nextLine();
            Joueur j=new Joueur(nomJoueur,numJoueur,pointMana);
            listJoueur.add(j);
            numJoueur+=1;
        }
        Plateau p= new Plateau();
        couleurJoueur();
        init();
        superPaquet();
        melanger(50);
        attaquer(p);
        plateauJeu();


    }


//    public void init() {
//            for (int j =0; j<14;j++){
//                Carte c =new Carte(j," ");
//                this.cartesTotal2.add(c);
//                this.cartesTotal1.add(c);
//            }
//        }

    public void choixPuissance(){
        for (int i=0; i<listJoueur.size();i++) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Saisissez un entier : ");
            int puissance = sc.nextInt();
            listJoueur.get(i).setPuissanceCoup(puissance);
            listJoueur.get(i).setPointMana(listJoueur.get(i).getPointMana() - puissance);
            if (puissance > listJoueur.get(i).getPointMana()) {
                System.out.println("Pas possible FDP recommence");
            } else {
                System.out.println(" Puissance du coup " + puissance);
                System.out.println("il reste " + listJoueur.get(i).getPointMana() + " points de Mana");
            }

        }
    }



    public void attaquer(Plateau plateau){
            plateau.getPlateauBase();
            plateau.setPlateauBase(plateau.getPlateauBase()[plateau.]);// ATTENTION
            System.out.println("Taille tab avant   "+plateau.getTailleTab());
            this.choixPuissance();
            if (listJoueur.get(0).getPuissanceCoup()<listJoueur.get(1).getPuissanceCoup()){
                System.out.println("Pas assez fort batard "+listJoueur.get(1).getNumJoueur() +" gagne");
                plateau.setPlaceMur(plateau.getPlaceMur()-1);

                System.out.println("Taille tab après "+plateau.getTailleTab());
                System.out.println("Place du mur "+plateau.getPlaceMur()+"    Place J1  "+plateau.getPlaceJ1()+"      Place J2  "+plateau.getPlaceJ2());
            }else if (listJoueur.get(0).getPuissanceCoup()> listJoueur.get(1).getPuissanceCoup()){

            System.out.println("Trop fort batard le joueur "+listJoueur.get(0).getNumJoueur()+" gagne");
            }else if (listJoueur.get(0).getPuissanceCoup()== listJoueur.get(1).getPuissanceCoup()){

                System.out.println(" Même patate pour les deux joueurs");
            }else {
                System.out.println("OUALALALA");
            }
    }

    public void plateauJeu(){
        if (nbManches==0) {
            int tableauEntier[] = new int[21];
            tableauEntier[19 / 2 + 1] = 11;
        }

//        for (int i = 1; i < tableauEntier.length; i++) {
//            System.out.print(" Connard de joueur 1 [" + i + "]=" + tableauEntier[i] + " ");
//        }
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

    public void couleurJoueur(){
        Random ra = new Random();

        int fonction = ra.nextInt(2);
        for (int i=0; i<listJoueur.size();i++) {
            if (fonction == 1) {
                System.out.println("Sorcier " + listJoueur.get(i).getNumJoueur() + " est le sorcier rouge");

            } else {
                System.out.println("Sorcier " + listJoueur.get(i).getNumJoueur() + "est le sorcier vert");

            }
        }
    }

    public void finTour(){

        finTour=true;
    }

    public void setFinManche(){

        finManche=true;
    }


}
