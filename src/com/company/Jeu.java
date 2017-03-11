package com.company;

import java.util.*;

/**
 * Created by Gaby on 24/02/2017.
 */
public class Jeu {

    private ArrayList<Joueur> listJoueur;
    private int nbJoueus = 2;
    private boolean finTour=false;
    private HashSet<Carte>cartesTotal1 = new HashSet<>();
    private HashSet<Carte>cartesTotal2 = new HashSet<>();
    private Carte[] cartesJ1 = new Carte[14];
    private Carte[] cartesJ2 = new Carte[14];
    int tableauEntier[] = new int[21];
    Boolean vert= false;
    Boolean rouge= false;
    private int nombreCarte;



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
        nbCarte();

    }

    public void init() {
            for (int j =1; j<14;j++){
                Carte c =new Carte(j," ");
                this.cartesTotal2.add(c);
                this.cartesTotal1.add(c);
            }
        }

    public void attaquer(){

    }

    public int nbCarte (){
        int i = 0;
        for (Carte carte : this.cartesTotal2){

            System.out.println(" CARTES TOTAL2 "+carte);
            i++;
        }for (Carte carte : this.cartesTotal1){

            System.out.println("CARTE TOTAL 1 "+cartesTotal1);
            i++;
        }
        return i;
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
