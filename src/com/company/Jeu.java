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
//        superPaquet();
        melanger(50);

        while (listJoueur.size()==2) {
            attaquer(p);
        }


    }


//    public void init() {
//            for (int j =0; j<14;j++){
//                Carte c =new Carte(j," ");
//                this.cartesTotal2.add(c);
//                this.cartesTotal1.add(c);
//            }
//        }

    public void choixPuissance(Plateau plateau){
        for (int i=0; i<listJoueur.size();i++) {

            if (listJoueur.get(i).getPointMana()==0){
                FinManche(plateau);
                System.out.println(" Joueur "+listJoueur.get(i).getNomJoueur()+" a plus de mana, fin du tour");

            }
            System.out.println("Joueur " + i + " à vous !");
            Scanner sc = new Scanner(System.in);
            System.out.println("Saisissez un entier : ");
            int puissance = sc.nextInt();

            if ((listJoueur.get(i).getPointMana()<=0)||(listJoueur.get(i).getPointMana()==0)){ // Condition si J1 a plus de points de mana
                System.out.println(" Joueur "+listJoueur.get(i).getNumJoueur()+" a perdu la manche");
                FinManche(plateau);
                System.out.println("Nouveau tour");
                break;
            } else if (puissance > listJoueur.get(i).getPointMana()) {
                System.out.println("Pas possible FDP recommence");
                System.out.println("Points de mana Joueur "+listJoueur.get(i).getPointMana());
                choixPuissance(plateau);
                break;
            }else {
                listJoueur.get(i).setPuissanceCoup(puissance);
                listJoueur.get(i).setPointMana(listJoueur.get(i).getPointMana() - puissance);
                System.out.println(" Puissance du coup " + puissance);
                System.out.println("il reste " + listJoueur.get(i).getPointMana() + " points de Mana");
            }
        }

    }

    public void attaquer(Plateau plateau){
            this.choixPuissance(plateau);

        Enumeration enumeration = plateau.plateauBase.elements();
        while (enumeration.hasMoreElements()) {
            System.out.println("Résultat du debut du tour " + enumeration.nextElement());
        }
            //Attaque du joueur 1 pas assez forte
            if (listJoueur.get(0).getPuissanceCoup() < listJoueur.get(1).getPuissanceCoup()) {
                System.out.println("Pas assez fort batard " + listJoueur.get(1).getNumJoueur() + " gagne le tour");
                plateau.setPlaceMur(plateau.getPlaceMur() - 1);
                plateau.plateauBase.put("J1", plateau.getPlaceJ1());
                plateau.plateauBase.put("m", plateau.getPlaceMur());
                plateau.plateauBase.put("J2", plateau.getPlaceJ2());
                if (plateau.getPlaceJ1()==0){          // Condition si J1 est à 0
                    System.out.println("Fin du game");
                }
               else if (plateau.getPlaceJ1()==plateau.getPlaceMur()){
                    System.out.println("Bien joué J2");
                    System.out.println("FIN DE LA MANCHE !!!! ");
                    System.out.println(listJoueur.get(1).getNomJoueur()+" gagne la manche");
                    nbManches+=1;
                    System.out.println("Nombre de manches " +nbManches);
                    FinManche(plateau);
                    System.out.println("Taille tab "+plateau.getTailleTab());
                    plateau.plateauBase.put("J1", plateau.getPlaceJ1()-3);
                    plateau.plateauBase.put("m", plateau.getPlaceMur());
                    plateau.plateauBase.put("J2", plateau.getPlaceJ2()-3);

                }


                //Attaque du joueur 2 pas assez forte
            } else if (listJoueur.get(0).getPuissanceCoup() > listJoueur.get(1).getPuissanceCoup()) {
                plateau.setPlaceMur(plateau.getPlaceMur() + 1);
                plateau.plateauBase.put("J1", plateau.getPlaceJ1());
                plateau.plateauBase.put("m", plateau.getPlaceMur());
                plateau.plateauBase.put("J2", plateau.getPlaceJ2());
                if (plateau.getPlaceJ2()==plateau.getPlaceMur()){
                    System.out.println(" Bien joué J1");
                    System.out.println("FIN DE LA MANCHE !!!! ");
                    System.out.println(listJoueur.get(0).getNomJoueur()+" gagne la manche");
                    nbManches+=1;
                    System.out.println("Nombre de manches " +nbManches);
                    FinManche(plateau);
                    System.out.println("Taille tab "+plateau.getTailleTab());
                    plateau.plateauBase.put("J1", plateau.getPlaceJ1()+3);
                    plateau.plateauBase.put("m", plateau.getPlaceMur());
                    plateau.plateauBase.put("J2", plateau.getPlaceJ2()+3);

                }if (plateau.getPlaceJ2()==plateau.getTailleTab()){          // Condition si J2 est au bout du plateau droit
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
            nbTours+=1;
    }



//        for (int i = 1; i < tableauEntier.length; i++) {
//            System.out.print(" Connard de joueur 1 [" + i + "]=" + tableauEntier[i] + " ");
//        }




    public void init() {
        for (int i = 0; i < 15; i++) {
            cartesJ1[i] = new Carte(i, "\n");
        }
        for (int i = 0; i < 15; i++) {
            cartesJ2[i] = new Carte(i, "\n");
        }
    }


    public void superPaquet(){

        for (int i = 1; i < cartesJ1.length; i++) {
            System.out.print(" Cartes joueur 1 [" + i + "]=" + cartesJ1[i] + " ");
        }
        for (int i = 1; i < cartesJ2.length; i++) {
            System.out.print(" Cartes joueur 2 [" + i + "]=" + cartesJ2[i] + " ");
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

        if (nbManches>=1){
        plateau.setTailleTab(plateau.getTailleTab()-2);
  //      for (int i=0; i<listJoueur.size();i++){
            listJoueur.get(0).setPointMana(50);
            System.out.println("Joueur "+listJoueur.get(0).getNomJoueur()+" a "+listJoueur.get(0).getPointMana()+" points de mana");
            listJoueur.get(1).setPointMana(50);
            System.out.println("Joueur "+listJoueur.get(1).getNomJoueur()+" a "+listJoueur.get(1).getPointMana()+" points de mana");
    //    }
        }
    }


}
