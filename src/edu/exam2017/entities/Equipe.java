/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.exam2017.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author MedAmineBou
 */
public class Equipe {
    
    private int id;
    private String nom;
    private String pays;
    private List<Joueur> joueurs; 

    public Equipe() {
        joueurs=new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public List<Joueur> getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(List<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Equipe other = (Equipe) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Equipe{" + "id=" + id + ", nom=" + nom + ", pays=" + pays + ", joueurs=" + joueurs + '}';
    }
    
    public void addJoueur(Joueur e)
    {
        joueurs.add(e);
    }
    
    public void supprimerJoueur(Joueur e)
    {
        joueurs.remove(e);
    }
    
    public boolean rechercheJoueurParNationalite(String nationalite)
    {
        return joueurs.stream().anyMatch(e->e.getNationalite().equals(nationalite));
    }
    
    public Map<String,List<Joueur>> regrouperParNationalite()
    {
        return joueurs.stream().collect(Collectors.groupingBy(Joueur::getNationalite));
    }
   
    
    
    
}
