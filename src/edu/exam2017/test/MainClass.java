/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.exam2017.test;

import edu.exam2017.entities.Competition;
import edu.exam2017.entities.EnsembleEquipe;
import edu.exam2017.entities.Equipe;
import edu.exam2017.entities.Fifa;
import edu.exam2017.entities.Joueur;

/**
 *
 * @author MedAmineBou
 */
public class MainClass {
    public static void main(String[] args)
    {
        EnsembleEquipe E= new EnsembleEquipe();
        Joueur j= new Joueur();
        j.setId(1);
        j.setNom("Chakib");
        j.setNationalite("Tunisien");
     
        
        Equipe e= new Equipe();
        e.setNom("Gafsa");
        e.setId(1);
        e.setPays("Tunisie");
        e.addJoueur(j);
        
         Equipe e1= new Equipe();
        e1.setNom("Kairouan");
        e1.setId(2);
        e1.setPays("France");
        e1.addJoueur(j);
        E.ajouterEquipe(e1);
        
         Equipe e2= new Equipe();
        e2.setNom("Ariana");
        e2.setId(3);
        e2.setPays("Tunisie");
        e2.addJoueur(j);
        E.ajouterEquipe(e2);
        
        
      //  (E.trierEquipesParNom()).stream().forEach(System.out::println);
        Competition c= new Competition();
        c.setNom("Coupe Du monde");
        c.setId(1);
        Fifa f=new Fifa();
        f.ajouterCompetition(c);
        f.ajouterEquipe(c, e1);
        
        Competition c2= new Competition();
        c2.setNom("Championnat");
        c2.setId(2);
        
        f.ajouterCompetition(c2);
        f.ajouterEquipe(c2, e);
        
       // f.afficherFifa();
        
       // f.retournerEquipesParPays("Tunisie").stream().forEach(System.out::println);
        
       // f.afficherEquipesPersonalisees(c,"Tounsi");
        
        //f.retournerCompetitionParJoueurTunisien().stream().forEach(System.out::println);
        
        System.out.println(f.returnSiUneEquipeParticipeEnPlusieursCompetitions());
    }
}
