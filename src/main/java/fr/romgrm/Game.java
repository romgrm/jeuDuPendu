package fr.romgrm;

import java.util.Random;
import java.util.*;
  
public class Game {
    String[] motsADeviner = {"voiture", "paradis", "marseille", "valise", "rapidemment", "zouk", "cigarette"};
    String[] motsADevinerCacher;
    String entrerUneLettre;  
    Player joueur = new Player("Player", 0);
    // boolean lettreCorrespondante = false;

    public void startGame(){
        System.out.println("\n" + "Bienvenu à toi " + joueur.getName() + " !"+"\n");
        System.out.println("\n" + "Tu connais sûrement les règles du jeu du pendu, alors on y va !" + "\n");
    }

    /**************************** TIRAGE AU SORT DU MOT DE MA LISTE *******************************/

    public String tirageDuMot(){
        int random = new Random().nextInt(motsADeviner.length); // on tire au sort avec l'index
        return motsADeviner[random]; // on retourne le tableau en fonction de l'index tiré au sort
    }
    /***************************************************************************************************/

    /************************ REMPLACEMENT PAR DES TIRETS LE MOT TIRER AU SORT ************************/
    
    public void cacherMot(){
        motsADevinerCacher = this.tirageDuMot().split(""); // j'execute la fonction du tirage au sort et je remplie mon nouveau tableau avec le résultat du tirage. 
        System.out.println(Arrays.toString(motsADevinerCacher));
        
        System.out.println("\n" + "Voici le mot à deviner : ");

         for (int i = 1; i < motsADevinerCacher.length; i++) { // je loop sur mon tableau qui vient d'etre rempli du mot a tirer au sort
            motsADevinerCacher[i] = "_"; // je remplace chq lettre avec un "__" en fonction de l'index. Je peux le faire grace au .split() qui a coupé chq lettre de mon mot
         }
        System.out.println(Arrays.toString(motsADevinerCacher));
        

        // Scanner scan = new Scanner(System.in);
        // entrerUneLettre = scan.next(); 
        // // return entrerUneLettre; 


        // for (int i = 0; i < this.motsADevinerCacher.length; i++) {
        //     System.out.println(Arrays.toString(motsADevinerCacher));
        //     if (motsADevinerCacher[i].matches("[" + this.entrerUneLettre + "]")){
        //         lettreCorrespondante = true;
        //         this.motsADevinerCacher[i] = this.motsADeviner[i];
        //     }
        // }
    }
    /*************************************************************************************/
    
    // public void afficherTest(){
    //     System.out.println(Arrays.toString(this.motsADevinerCacher));
    // }
    
    /**************************** ENTRER UNE LETTRE *******************************/

    public String entrerUneLettre(){
        Scanner scan = new Scanner(System.in);
        entrerUneLettre = scan.next(); 
        return entrerUneLettre; 
    }
    /*************************************************************************************/
    
    /**************************** VERIFIER CORRESPONDANCE *******************************/
    
      public void remplacerLettre() {

        // boolean lettreCorrespondante = false;
        
        for (int i = 1; i < this.motsADevinerCacher.length; i++) {
            
            if(this.motsADevinerCacher[i].equals(this.entrerUneLettre)){
                System.out.println("bingo");
            }else{
                System.out.println("shit");
            }
        }


        // if (this.motsADevinerCacher[i].matches(this.entrerUneLettre)){
        //     // lettreCorrespondante = true;
        //     System.out.println("bingo");
        //     this.motsADevinerCacher[i] = this.motsADeviner[i];
        //     System.out.println(Arrays.toString(this.motsADevinerCacher));
        // }
        // if (lettreCorrespondante == true) {

        //     System.out.println("Bravo, une lettre de plus trouvée !\n");
        //     this.joueur.setScore(+1);
        //  }else{
        //      System.out.println("try again");
        //  }
         
         // else if (this.essaisRestants != 0) {
        //     this.essaisRestants--;
        //     System.out.println("Pas la bonne lettre! Essayez encore.Plus que " + this.essaisRestants + " essais.\n");

        // }

    }
        
}