package com.company;

import java.awt.*;
import java.util.*;

/**
 * Created by Gaby on 24/02/2017.
 */
public class Jeu {

    private ArrayList<Joueur> listJoueur;
    private int nbJoueus;
    private int nbManches=1;
    private int nbTours;
    private boolean finTour=false;
    private boolean finManche=false;
    private Carte[] cartesJ1 = new Carte[15];
    private Carte[] cartesJ2 = new Carte[15];
    private ArrayList <Carte> listCarte;



    public void debutJeu(){
        this.listCarte=new ArrayList<Carte>();
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

        while (listJoueur.size()==2) {

            attaquer(p);
        }


    }


       public void init() {
            for (int j =0; j<14;j++){
                Carte c =new Carte(j," ");
                this.listCarte.add(c);

            }
        }

    public void choixPuissance(Plateau plateau){
        System.out.println(" le nombre de cases est de "+plateau.getTailleTab());
        for (int i=0; i<listJoueur.size();i++) {

            if (listJoueur.get(i).getPointMana()==0){
                FinManche(plateau);
                System.out.println(" Joueur "+listJoueur.get(i).getNomJoueur()+" a plus de mana, fin du tour");
            }


            System.out.println("Joueur " + listJoueur.get(i).getNomJoueur() + " à vous !");
            Scanner sc = new Scanner(System.in);
            System.out.println("Saisissez un entier : ");
            int puissance = sc.nextInt();

            if ((listJoueur.get(i).getPointMana()<=0)){ // Condition si J1 a plus de points de mana
                FinManche(plateau);
                System.out.println(" Joueur "+listJoueur.get(i).getNumJoueur()+" a perdu la manche");
                System.out.println("Nouveau tour");
                break;
            } else if (puissance > listJoueur.get(i).getPointMana()) {
                System.out.println("Pas possible FDP recommence");
                System.out.println("Points de mana Joueur "+listJoueur.get(i).getPointMana());
                choixPuissance(plateau);
                break;
            }
            else {
                listJoueur.get(i).setPuissanceCoup(puissance);
                listJoueur.get(i).setPointMana(listJoueur.get(i).getPointMana() - puissance);
                System.out.println(" Puissance du coup " + puissance);
                this.choixCarte(plateau);
                System.out.println(" la puissance du coup est "+listJoueur.get(i).getPuissanceCoup());
                System.out.println("il reste " + listJoueur.get(i).getPointMana() + " points de Mana");
                System.out.println("");

            }

        }


    }

    public void attaquer(Plateau plateau) {
        this.choixPuissance(plateau);
//        Enumeration enumeration = plateau.plateauBase.elements();
//        while (enumeration.hasMoreElements()) {
//            System.out.println("Résultat du debut du tour " + enumeration.nextElement());
//        }
            //Attaque du joueur 1 pas assez forte

            if (listJoueur.get(0).getPuissanceCoup() < listJoueur.get(1).getPuissanceCoup()) {
                System.out.println("Pas assez fort batard " + listJoueur.get(1).getNumJoueur() + " gagne le tour");
                plateau.setPlaceMur(plateau.getPlaceMur() - 1);
                plateau.plateauBase.put("m", plateau.getPlaceMur());
                if (plateau.getPlaceJ1() == 0) {          // Condition si J1 est à 0
                    System.out.println("Fin du game");
                } else if (plateau.getPlaceJ1() == plateau.getPlaceMur()) {
                    System.out.println("Bien joué J2");
                    System.out.println("FIN DE LA MANCHE !!!! ");
                    System.out.println(listJoueur.get(1).getNomJoueur() + " gagne la manche");
                    System.out.println("Nombre de manches " + nbManches);
                    FinManche(plateau);
                    System.out.println("Taille tab " + plateau.getTailleTab());
                    plateau.plateauBase.put("J1", plateau.getPlaceJ1() - 3);
                    plateau.plateauBase.put("J2", plateau.getPlaceJ2() - 3);

                }

                //Attaque du joueur 2 pas assez forte
            } else if (listJoueur.get(0).getPuissanceCoup() > listJoueur.get(1).getPuissanceCoup()) {
                plateau.setPlaceMur(plateau.getPlaceMur() + 1);
                plateau.plateauBase.put("m", plateau.getPlaceMur());
                if (plateau.getPlaceMur() >= plateau.getPlaceJ2()) {
                    plateau.plateauBase.put("J1", plateau.getPlaceJ1() + 3);
                    plateau.plateauBase.put("J2", plateau.getPlaceJ2() + 3);
                    System.out.println(" Bien joué J1");
                    System.out.println("FIN DE LA MANCHE !!!! ");
                    System.out.println(listJoueur.get(0).getNomJoueur() + " gagne la manche");
                    FinManche(plateau);
                    System.out.println("Taille tab " + plateau.getTailleTab());

                }
                if (plateau.getPlaceJ2() == plateau.getTailleTab()) {          // Condition si J2 est au bout du plateau droit
                    System.out.println("Fin du game");

                }
            } else if (listJoueur.get(0).getPuissanceCoup() == listJoueur.get(1).getPuissanceCoup()) {

                System.out.println(" Même patate pour les deux joueurs");
            } else {
                System.out.println("OUALALALA");
            }

            Enumeration enumeration2 = plateau.plateauBase.elements();
            while (enumeration2.hasMoreElements()) {
                System.out.println("Résultat de la fin du tour " + enumeration2.nextElement());
            }
            nbTours += 1;
        }




//        for (int i = 1; i < tableauEntier.length; i++) {
//            System.out.print(" Connard de joueur 1 [" + i + "]=" + tableauEntier[i] + " ");
//        }




//    public void init() {
//        for (int i = 0; i < 6; i++) {
//            cartesJ1[i] = new Carte(i, "\n");
//            melanger(50);
//
//        }
//        for (int i = 0; i < 6; i++) {
//            cartesJ2[i] = new Carte(i, "\n");
//            melanger(50);
//
//        }
//    }

    public void choixCarte(Plateau plateau){

        this.pouvoirCarte(plateau);
    }

    public void pouvoirCarte(Plateau plateau){
        for (int i = 0;i<listJoueur.size();i++) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Saisissez une carte : ");
            int choixCarte = sc.nextInt();

            if (choixCarte == 1) { // Mutisme
                listJoueur.get(i).setPuissanceCoup(i);
                System.out.println(" Carte Mutisme");
                break;

            } else if (choixCarte == 2) { //carte Clone
                break;

            } else if (choixCarte == 3) { // carte Larcin

                break;
            } else if (choixCarte == 4) { //carte Fin de manche

                break;
            } else if (choixCarte == 5) { //carte Milieu
                plateau.setPlaceMur(10);

                break;
            } else if (choixCarte == 6) {  //carte Recyclage
                Scanner sc2 = new Scanner(System.in);
                System.out.println("P ou M ? ");
                int choix = sc.nextInt();
                break;
            } else if (choixCarte == 7) {//carte Boost
                listJoueur.get(i).setPuissanceCoup(listJoueur.get(i).getPuissanceCoup() + 7);
                break;
            } else if (choixCarte == 8) { // Double dose
                listJoueur.get(i).setPuissanceCoup(listJoueur.get(i).getPuissanceCoup() * 2);
                break;
            } else if (choixCarte == 9) { //carte Qui perd gagne
                break;

            } else if (choixCarte == 10) { //carte Brasier
                break;

            } else if (choixCarte == 11) { // carte Résistance
                break;

            } else if (choixCarte == 12) { // Harpagon
                break;

            } else if (choixCarte == 13) { // Boost réserve
                listJoueur.get(i).setPointMana(listJoueur.get(i).getPointMana() + 13);
                break;
            } else if (choixCarte == 14) { //Aspiration
                break;

            }
        }
    }



    public void superPaquet(){

//        for (int i = 1; i < cartesJ1.length; i++) {
//            System.out.print(" Cartes joueur 1 [" + i + "]=" + cartesJ1[i] + " ");
//        }

//        for (int i = 1; i < cartesJ2.length; i++) {
//            System.out.print(" Cartes joueur 2 [" + i + "]=" + cartesJ2[i] + " ");
//        }

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
        Boolean coulVert= false;
        Boolean coulRouge= false;
        int fonction = ra.nextInt(2);
            if (fonction == 1) {
               coulRouge=true;
                System.out.println("Sorcier " + listJoueur.get(0).getNomJoueur() + " est le sorcier rouge");
                if (coulRouge==true){
                    System.out.println("Sorcier " + listJoueur.get(1).getNomJoueur() + " est le sorcier vert");

                }
            } else {
                coulVert=true;
                System.out.println("Sorcier " + listJoueur.get(0).getNomJoueur() + " est le sorcier vert");
                System.out.println("Sorcier " + listJoueur.get(1).getNomJoueur() + " est le sorcier rouge");
            }
        }


    public void FinManche(Plateau plateau){
  //      for (int i=0; i<listJoueur.size();i++){
            listJoueur.get(0).setPointMana(50);
            System.out.println("Joueur "+listJoueur.get(0).getNomJoueur()+" a "+listJoueur.get(0).getPointMana()+" points de mana");
            listJoueur.get(1).setPointMana(50);
            System.out.println("Joueur "+listJoueur.get(1).getNomJoueur()+" a "+listJoueur.get(1).getPointMana()+" points de mana");
//            plateau.plateauBase.put("J1", plateau.getPlaceJ1()+3);
//            plateau.plateauBase.put("m", plateau.getPlaceMur());
//            plateau.plateauBase.put("J2", plateau.getPlaceJ2()+3);
//            nbManches+=1;
            if (nbManches>1){
                plateau.setTabLave(plateau.getTabLave()-2);
                System.out.println("LAVE "+plateau.getTabLave());
                plateau.plateauBase.put("J1", plateau.getPlaceJ1()+3);
            plateau.plateauBase.put("m", plateau.getPlaceMur());
            plateau.plateauBase.put("J2", plateau.getPlaceJ2()+3);
            }
        // }
    }


}
