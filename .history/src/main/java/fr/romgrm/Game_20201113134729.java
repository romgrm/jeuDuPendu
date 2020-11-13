package fr.romgrm;

import java.util.Random;
import java.util.*;
  
public class Game {
    String[] motsADeviner = {"voiture", "lit", "paris", "valise", "rideau", "zouk", "chaise"};
    String[] motAvecTirets;
    String[] motADevinerFixe;
    String entrerUneLettre; 
    int random = 0;
    int essaiRestant = 7; 
    Scanner scan = new Scanner(System.in);
    
      
    Player joueur = new Player("Player", 0);
    // boolean lettreCorrespondante = false;

    public void startGame(){
        System.out.println("\n" + "Bienvenu à toi " + joueur.getName() + " !"+"\n");
        System.out.println("\n" + "Tu connais sûrement les règles du jeu du pendu, alors on y va !" + "\n");
    }

    /**************************** TIRAGE AU SORT DU MOT DE MA LISTE *******************************/

    public String tirageDuMot(){
        this.random = new Random().nextInt(motsADeviner.length); // on tire au sort avec l'index
        return motsADeviner[random]; // on retourne le tableau en fonction de l'index tiré au sort
    }
    /***************************************************************************************************/

    /************************ REMPLACEMENT PAR DES TIRETS LE MOT TIRER AU SORT ************************/
    
    public void cacherMot(){
        motAvecTirets = this.tirageDuMot().split(""); // j'execute la fonction du tirage au sort et je remplie mon nouveau tableau avec le résultat du tirage. 
        System.out.println(Arrays.toString(motAvecTirets));
        
        System.out.println("\n" + "Voici le mot à deviner : ");

         for (int i = 1; i < motAvecTirets.length; i++) { // je loop sur mon tableau qui vient d'etre rempli du mot a tirer au sort
            motAvecTirets[i] = "_"; // je remplace chq lettre avec un "__" en fonction de l'index. Je peux le faire grace au .split() qui a coupé chq lettre de mon mot
         }
        System.out.println(Arrays.toString(motAvecTirets));
    }

    /*************************************************************************************/

    /**************************** RANDOM MOT FIXE *******************************/

    public void randomMotFixe(){
        motADevinerFixe = this.motsADeviner[random].split(""); // je remplie mon tableau avec le mot a deviner tiré au sort, également splitté
        System.out.println(Arrays.toString(motADevinerFixe)); // le but étant d'avoir le mot random de manière fixe, et de pouvoir le comparer 
                                                                // avec le motAvecTirets, car sinon on comparerai tous les mots random du tableau de base 
    }

    /*************************************************************************************/
    
    /**************************** ENTRER UNE LETTRE *******************************/

    public String entrerUneLettre(){
        entrerUneLettre = scan.next(); 
        return entrerUneLettre;  
    }
    /*************************************************************************************/
    
    /**************************** VERIFIER CORRESPONDANCE *******************************/
    
    public void remplacerLettre() {
        boolean goodAnswer = false; 
        
        for (int i = 1; i < this.motsADeviner.length; i++) { // je boucle sur n'importe quelle longueur de tableau vu que c'est tjrs le même mot 
            try {
                if(entrerUneLettre.equals(motADevinerFixe[i])){ // si l'entree clavier correspond a une des lettres([i]) de mon mot Fixe
                    goodAnswer = true; 
                    this.motAvecTirets[i] = this.motADevinerFixe[i]; // alors tu remplace l'index tiret, par l'index de la lettre correspondante
                    System.out.println("Félicitations, une lettre de trouver ! À la suivante : " + "\n");
                    System.out.println(Arrays.toString(motAvecTirets));
                    return; 
                }
            }catch (ArrayIndexOutOfBoundsException e) {
                //System.out.println("pas bon");
            }
        } 
        /************** MAUVAISE LETTRE *********************************/
        if(goodAnswer == false){
            System.out.println("OUPS ! Mauvaise lettre !");
            this.essaiRestant--; 
                if(essaiRestant == 0){
                    System.out.println("PENDU !");
                }else{
                    System.out.println("il vous reste " + this.essaiRestant + " essais. Essayez une autre lettre : ");
                }
            
        }
        
            
    }

    /*************************************************************************************/
    
    /*************************************** REPLAY **************************************/
    public void replay(){
        
        while (this.motAvecTirets != this.motADevinerFixe) {
            victory();
            entrerUneLettre(); 
            remplacerLettre(); 
        }
    }

    /*************************************************************************************/
    
    /**************************** VICTORY *******************************/
    public void victory(){
        if(Arrays.equals(this.motAvecTirets, this.motADevinerFixe)){
            try {
                System.out.println("GAGNER !");
                scan.close();
            } catch (IllegalStateException e) {
                System.out.println(" Voulez-vous rejouer ?");
            }
             
        }
    }

        
}